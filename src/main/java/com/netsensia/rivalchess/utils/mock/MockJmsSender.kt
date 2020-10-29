package com.netsensia.rivalchess.utils.mock

import com.netsensia.rivalchess.utils.`interface`.JmsSenderInterface
import com.netsensia.rivalchess.vie.model.EngineSettings

object MockJmsSender : JmsSenderInterface {
    val engineSettingsList = mutableListOf<EngineSettings>()

    override fun send(subject: String, message: Any) {
        val engineSettingsMessage = message as EngineSettings
        engineSettingsList.add(engineSettingsMessage)
    }
}