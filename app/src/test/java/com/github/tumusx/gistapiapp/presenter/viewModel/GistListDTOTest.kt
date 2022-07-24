package com.github.tumusx.gistapiapp.presenter.viewModel

import com.github.tumusx.gistapiapp.data.model.listGist.Files
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class GistListDTOTest {

    @Test
    fun `eperado retornar um mapeamento no DTO dinamico de acordo com o nome do arquivo`() {
        val value: MutableMap<String, Files> = HashMap<String, Files>()
        value.put("Jose", Files("luizalabs", "pt-br", "luizalabs.com", 1, "luizalabs.txt"))
        assertEquals(value.keys, GistListDTOMock.gistMap().keys)
    }

    @Test
    fun `esperado retornar valores de chave valor nao nullas para mudar de forma dinamica o nome do file`(){
        assertNotNull(GistListDTOMock.setMockDTO().files)
    }
}