package com.geektech.myloveanim.data.server

import com.geektech.myloveanim.model.AnimModel

object LocalServer {

    fun getAnimList():List<AnimModel>{
        val animList:ArrayList<AnimModel> = ArrayList()
        animList.add(AnimModel("1.Магическая битва"))
        animList.add(AnimModel("2.Баракамон"))
        animList.add(AnimModel("3.Атака титанов"))
        animList.add(AnimModel("4.Владыка"))
        animList.add(AnimModel("5.Любимый во франксе"))
        animList.add(AnimModel("6.Необъятный океан"))
        animList.add(AnimModel("7.Джо Джо"))
        animList.add(AnimModel("8.Вайолет Эвергарден"))
        animList.add(AnimModel("9.Нет игры - нет жизни"))
        animList.add(AnimModel("10.Да, я Сакомото, а что?"))
        animList.add(AnimModel("11.В любви как на войне"))
        animList.add(AnimModel("12.Сатана на подработке"))

        return animList
    }
}