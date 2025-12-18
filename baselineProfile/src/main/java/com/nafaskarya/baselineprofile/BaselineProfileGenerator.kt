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

            device.wait(Until.hasObject(By.pkg(targetPackage).scrollable(true)), 15000)
            device.waitForIdle()

            val scrollables = device.findObjects(By.pkg(targetPackage).scrollable(true))
            val mainVerticalScroll = scrollables.find { it.visibleBounds.height() > it.visibleBounds.width() }

            if (mainVerticalScroll != null) {
                mainVerticalScroll.setGestureMargin(device.displayWidth / 10)
                try {
                    while (mainVerticalScroll.fling(Direction.DOWN)) { }
                    device.waitForIdle()
                    while (mainVerticalScroll.fling(Direction.UP)) { }
                    device.waitForIdle()
                } catch (e: Exception) { }
            }

            try {
                val sliders = device.findObjects(By.pkg(targetPackage).scrollable(true))
                val horizontalSlider = sliders.find { it.visibleBounds.width() > it.visibleBounds.height() }
                if (horizontalSlider != null) {
                    horizontalSlider.setGestureMargin(device.displayWidth / 10)
                    horizontalSlider.scroll(Direction.RIGHT, 1.0f)
                    device.waitForIdle()
                    horizontalSlider.scroll(Direction.LEFT, 1.0f)
                    device.waitForIdle()
                }
            } catch (e: Exception) { }

            try {
                val cards = device.findObjects(By.pkg(targetPackage).clickable(true))
                    .filter { try { it.visibleBounds.height() > 200 && it.visibleBounds.centerY() < device.displayHeight * 0.8 } catch (e: Exception) { false } }

                val card = cards.getOrNull(0)
                if (card != null) {
                    card.click()
                    device.wait(Until.hasObject(By.pkg(targetPackage)), 5000)
                    device.waitForIdle()
                    device.pressBack()
                    device.waitForIdle()
                }
            } catch (e: Exception) { }

            val profileBtn = device.wait(Until.findObject(By.desc("Profile Button")), 5000)
            if (profileBtn != null) {
                profileBtn.click()
                device.wait(Until.hasObject(By.textContains("Profil")), 5000)

                val profileScroll = device.findObject(By.scrollable(true))
                profileScroll?.setGestureMargin(device.displayWidth / 10)
                profileScroll?.fling(Direction.DOWN)
                device.waitForIdle()

                device.pressBack()
                device.waitForIdle()
            }

            device.pressHome()
            device.waitForIdle()
        }
    }
}