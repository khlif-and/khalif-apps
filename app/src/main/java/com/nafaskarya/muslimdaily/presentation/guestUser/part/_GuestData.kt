package com.nafaskarya.muslimdaily.presentation.guestUser.part

import com.nafaskarya.muslimdaily.R
import com.nafaskarya.muslimdaily.presentation.core.commons.models.CompilationCardModel
import com.nafaskarya.muslimdaily.presentation.core.commons.models.CompilationModelSubItem
import com.nafaskarya.muslimdaily.presentation.core.commons.models.ContentItem

object GuestData {
    val genZList = listOf(
        ContentItem(
            R.string.item_gen_z_1_title,
            R.string.item_gen_z_1_desc,
            R.drawable.img_onboarding
        ),
        ContentItem(
            R.string.item_gen_z_2_title,
            R.string.item_gen_z_2_desc,
            R.drawable.img_onboarding
        ),
        ContentItem(
            R.string.item_gen_z_3_title,
            R.string.item_gen_z_3_desc,
            R.drawable.img_onboarding
        ),
        ContentItem(
            R.string.item_gen_z_4_title,
            R.string.item_gen_z_4_desc,
            R.drawable.img_onboarding
        )
    )

    val trendingList = listOf(
        ContentItem(
            R.string.item_trend_1_title,
            R.string.item_trend_1_desc,
            R.drawable.img_onboarding
        ),
        ContentItem(
            R.string.item_trend_2_title,
            R.string.item_trend_2_desc,
            R.drawable.img_onboarding
        ),
        ContentItem(
            R.string.item_trend_3_title,
            R.string.item_trend_3_desc,
            R.drawable.img_onboarding
        ),
        ContentItem(
            R.string.item_trend_4_title,
            R.string.item_trend_4_desc,
            R.drawable.img_onboarding
        )
    )

    val kitabList = listOf(
        CompilationCardModel(
            title = "Kisah Hewan Aneh",
            subtitle = "Cerita legend versi Gen Z",
            caption = "87 kisah pilihan",
            items = listOf(
                CompilationModelSubItem("Unta Menangis", "Tentang tobat", R.drawable.img_onboarding),
                CompilationModelSubItem("Burung Pos", "Tentang amanah", R.drawable.img_onboarding),
                CompilationModelSubItem("Serigala Saksi", "Tentang keadilan", R.drawable.img_onboarding)
            )
        ),
        CompilationCardModel(
            title = "Misteri Alam Kubur",
            subtitle = "Bikin merinding tapi tobat",
            caption = "12 Kisah Nyata",
            items = listOf(
                CompilationModelSubItem("Malam Pertama", "Gelap gulita", R.drawable.img_onboarding),
                CompilationModelSubItem("Pertanyaan Malaikat", "Siapkan jawaban", R.drawable.img_onboarding),
                CompilationModelSubItem("Teman Setia", "Amal jariyah", R.drawable.img_onboarding)
            )
        )
    )

    val doaList = listOf(
        CompilationCardModel(
            title = "Doa Harian Mustajab",
            subtitle = "Jalur langit paling express",
            caption = "Kumpulan Doa Nabi",
            items = listOf(
                CompilationModelSubItem("Doa Lunas Hutang", "Dibaca sebelum tidur", R.drawable.img_onboarding),
                CompilationModelSubItem("Doa Jodoh", "Biar ga jomblo terus", R.drawable.img_onboarding),
                CompilationModelSubItem("Doa Ujian", "Biar lulus cumlaude", R.drawable.img_onboarding)
            )
        )
    )
}