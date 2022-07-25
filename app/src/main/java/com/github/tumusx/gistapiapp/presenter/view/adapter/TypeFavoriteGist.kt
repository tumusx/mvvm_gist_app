package com.github.tumusx.gistapiapp.presenter.view.adapter

enum class TypeFavoriteGist(val nameUserGist: String, val imgUserGit: String) {
    FIRST_USER_FAVORITE("magalu.BR",
        "https://i0.wp.com/www.economicnewsbrasil.com.br/wp-content/uploads/2022/05/Captura-de-Tela-2022-05-02-a%CC%80s-19.02.52.png?fit=1102%2C1042&ssl=1"),
    SECOND_USER_FAVORITE("luiza.labs.mundial", "https://cdn-images-1.medium.com/max/1200/1*IVax5__p6o5n1YPgugiqGQ.png"),
    THIRD_USER_FAVORITE("jovem.nerd.companuy/magalu", "https://www.publicitarioscriativos.com/wp-content/uploads/2021/04/1.png");

    companion object{
        fun getListMagalu() : MutableList<TypeFavoriteGist> {
            val setListITems = mutableListOf<TypeFavoriteGist>()
            setListITems.add(FIRST_USER_FAVORITE)
            setListITems.add(SECOND_USER_FAVORITE)
            setListITems.add(THIRD_USER_FAVORITE)
            return setListITems
        }
    }
}