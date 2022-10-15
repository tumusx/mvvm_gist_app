package com.github.tumusx.gistapiapp.presenter.viewModel

import com.github.tumusx.gistapiapp.data.model.listGist.GistsListDTOItem
import com.github.tumusx.gistapiapp.domain.useCase.GistListUseCaseImpl
import io.mockk.impl.annotations.MockK
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.DisplayName

class GistListViewModelTest {

    @get:Rule
    val getRuleInternal = 0

    @MockK
    lateinit var viewModel: GistListViewModel

    @MockK
    lateinit var gistListUseCaseImpl: GistListUseCaseImpl

    @Test
    @DisplayName("quando chamar metodo para obter lista de gists")
    fun whenCallMethodList() {
        val gistList = mutableListOf<GistsListDTOItem>(GistsListDTOItem())
    }

    fun gistListViewModel(): GistListViewModel {
        return GistListViewModel(gistListUseCaseImpl)
    }
}