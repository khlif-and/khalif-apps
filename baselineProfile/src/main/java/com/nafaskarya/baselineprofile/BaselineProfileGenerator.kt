package com.nafaskarya.baselineprofile

import androidx.benchmark.macro.junit4.BaselineProfileRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import androidx.test.uiautomator.Until
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class BaselineProfileGenerator {

    @get:Rule
    val rule = BaselineProfileRule()

    @Test
    fun generate() {
        val targetPackage = "com.nafaskarya.muslimdaily"

        rule.collect(
            packageName = targetPackage,
            includeInStartupProfile = true
        ) {
            pressHome()
            startActivityAndWait()

            // bypass onboarding
            device.wait(Until.findObject(By.desc("Login Button")), 5000)?.click()
            device.waitForWindowUpdate(targetPackage, 5000)

            // 1. SCROLL DULU (Vertical)
            val mainScrollable = device.wait(Until.findObject(By.pkg(targetPackage).scrollable(true)), 5000)
            if (mainScrollable != null) {
                mainScrollable.setGestureMargin(device.displayWidth / 10)
                try {
                    while (mainScrollable.fling(Direction.DOWN)) { }
                    device.waitForWindowUpdate(targetPackage, 2000)
                    while (mainScrollable.fling(Direction.UP)) { }
                } catch (e: Exception) { }
            }

            // 2. SLIDE DULU (Horizontal)
            repeat(2) { index ->
                try {
                    val sliders = device.findObjects(By.pkg(targetPackage).scrollable(true))
                    val slider = sliders.getOrNull(index)
                    if (slider != null && slider.visibleBounds.width() > slider.visibleBounds.height()) {
                        slider.setGestureMargin(device.displayWidth / 10)
                        while (slider.scroll(Direction.RIGHT, 1.0f)) { }
                        device.waitForWindowUpdate(targetPackage, 1000)
                        while (slider.scroll(Direction.LEFT, 1.0f)) { }
                    }
                } catch (e: Exception) { }
            }

            // 3. BARU KLIK CARD
            repeat(2) { index ->
                try {
                    val cards = device.findObjects(By.pkg(targetPackage).clickable(true))
                        .filter { try { it.visibleBounds.height() > 200 } catch (e: Exception) { false } }

                    val card = cards.getOrNull(index)
                    if (card != null) {
                        card.click()
                        device.waitForWindowUpdate(targetPackage, 3000)
                        device.pressBack()
                        device.waitForWindowUpdate(targetPackage, 2000)
                    }
                } catch (e: Exception) { }
            }

            // 4. LALU PROFILE
            val profileBtn = device.wait(Until.findObject(By.desc("Profile Button")), 5000)
            if (profileBtn != null) {
                profileBtn.click()
                device.wait(Until.hasObject(By.textContains("Profil")), 5000)

                // Scroll di dalam profil
                device.findObject(By.scrollable(true))?.fling(Direction.DOWN)
                device.waitForWindowUpdate(targetPackage, 2000)
            }

            device.pressHome()
        }
    }
}