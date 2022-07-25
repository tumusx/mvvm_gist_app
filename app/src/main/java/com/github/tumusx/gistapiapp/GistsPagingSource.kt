package com.github.tumusx.gistapiapp

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.tumusx.gistapiapp.data.model.listGist.GistsListDTOItem
import com.github.tumusx.gistapiapp.data.remote.GistsService
import com.github.tumusx.gistapiapp.utils.ConstUtils

class GistsPagingSource(private val service: GistsService) : PagingSource<Int, GistsListDTOItem>() {

    override fun getRefreshKey(state: PagingState<Int, GistsListDTOItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GistsListDTOItem> {
        val pageIndex = params.key ?: ConstUtils.START_PAGE_GITHUB_INDEX
        return try {
            val response = service.getListGist(page = pageIndex)
            val nextKey = if (response.isEmpty()) {
                null
            } else {
                pageIndex + (params.loadSize / ConstUtils.NETWORK_PAGE_SIZE)
            }
            LoadResult.Page(
                data = response,
                prevKey = if (pageIndex == ConstUtils.START_PAGE_GITHUB_INDEX) null else pageIndex,
                nextKey = nextKey
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }
}