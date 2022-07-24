package com.github.tumusx.gistapiapp.presenter.viewModel

import com.github.tumusx.gistapiapp.data.model.listGist.Files
import com.github.tumusx.gistapiapp.data.model.listGist.GistsListDTOItem

object GistListDTOMock {
    fun gistMap(): MutableMap<String, Files>{
        val map : MutableMap<String, Files> = HashMap<String, Files>()
        map.put("Jose", Files("luizalabs", "pt-br", "luizalabs.com", 1, "luizalabs.txt"))
        return map
    }

    fun setMockDTO() = GistsListDTOItem(
            1, "s", "a", "a", "a" +
                    "a", gistMap() , "a", "pull", "push", "id", "1",
            "nodeid", null, true, true, "as", "as", true
    )
}