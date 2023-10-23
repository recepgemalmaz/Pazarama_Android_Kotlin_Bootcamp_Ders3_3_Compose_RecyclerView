package com.recepgemalmaz.pazarama_bootcamp_ders_3_3_jackpack_compose_recyclerview

data class Finans(var isim:String = "", var deger:Float = 0.0F, var tarih:String = "")

class GunlukVeriler
{
    fun Get() : MutableList<Finans>
    {
        return mutableListOf(
            Finans("Dolar", 27.89F, "21.10.23"),
            Finans("Euro", 33.45F, "21.10.23"),
            Finans("Paund", 45.12F, "21.10.23"),
            Finans("Gram Altın", 1570.0F, "21.10.23"),
            Finans("Bitcoin", 100000.0F, "21.10.23"),
            Finans("Bist100", 15000.0F, "21.10.23"),
            Finans("Etherium", 5000.0F, "21.10.23"),
            Finans("Dogecoin", 1000.0F, "21.10.23"),
            Finans("Dolar", 27.89F, "21.10.23"),
            Finans("Euro", 33.45F, "21.10.23"),
            Finans("Paund", 45.12F, "21.10.23"),
            Finans("Gram Altın", 1570.0F, "21.10.23"),
            Finans("Bitcoin", 100000.0F, "21.10.23"),
            Finans("Bist100", 15000.0F, "21.10.23"),
            Finans("Etherium", 5000.0F, "21.10.23"),
            Finans("Dogecoin", 1000.0F, "21.10.23")
        )
    }
}