package com.nafaskarya.baselineprofile

import androidx.benchmark.macro.junit4.BaselineProfileRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
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

            device.wait(Until.hasObject(By.pkg(targetPackage)), 15000)
            device.waitForIdle()

            val mainScrollable = device.wait(Until.findObject(By.pkg(targetPackage).scrollable(true)), 10000)
            if (mainScrollable != null) {
                mainScrollable.setGestureMargin(device.displayWidth / 10)
                while (mainScrollable.fling(Direction.DOWN)) { }
                device.waitForIdle()
                while (mainScrollable.fling(Direction.UP)) { }
                device.waitForIdle()
            }

            val sliders = device.findObjects(By.pkg(targetPackage).scrollable(true))
            sliders.forEach { slider ->
                if (slider.visibleBounds.width() > slider.visibleBounds.height()) {
                    slider.setGestureMargin(device.displayWidth / 10)
                    while (slider.scroll(Direction.RIGHT, 1.0f)) { }
                    device.waitForIdle()
                    while (slider.scroll(Direction.LEFT, 1.0f)) { }
                    device.waitForIdle()
                }
            }

            val cards = device.findObjects(By.pkg(targetPackage).clickable(true))
                .filter { it.visibleBounds.height() > 200 }

            cards.forEach { card ->
                try {
                    card.click()
                    device.wait(Until.hasObject(By.pkg(targetPackage)), 5000)
                    device.waitForIdle()
                    device.pressBack()
                    device.waitForIdle()
                } catch (e: Exception) { }
            }

            val footer = device.wait(Until.findObject(By.pkg(targetPackage).desc("Open Player")), 5000)
            footer?.click()

            device.wait(Until.hasObject(By.pkg(targetPackage).desc("Collapse")), 5000)

            val actions = listOf("Shuffle", "Previous", "Play", "Next", "Timer", "Share", "More options")
            actions.forEach { action ->
                device.findObject(By.pkg(targetPackage).desc(action))?.click()
                device.waitForIdle(800)
                if (action == "Timer" || action == "Share" || action == "More options") {
                    device.pressBack()
                    device.wait(Until.hasObject(By.pkg(targetPackage).desc("Collapse")), 3000)
                    device.waitForIdle()
                }
            }

            device.findObject(By.pkg(targetPackage).desc("Collapse"))?.click()
            device.waitForIdle()

            val profileBtn = device.wait(Until.findObject(By.pkg(targetPackage).desc("Profile Button")), 5000)
            profileBtn?.click()

            device.wait(Until.hasObject(By.pkg(targetPackage).textContains("Profil")), 5000)

            val menus = device.findObjects(By.pkg(targetPackage).clickable(true))
                .filter { m -> m.text?.isNotEmpty() == true && !m.text.contains("Back", true) }

            menus.forEach { menu ->
                try {
                    menu.click()
                    device.waitForIdle()
                    device.pressBack()
                    device.wait(Until.hasObject(By.pkg(targetPackage).textContains("Profil")), 3000)
                    device.waitForIdle()
                } catch (e: Exception) { }
            }

            device.pressBack()
            device.waitForIdle(2000)
        }
    }
}