package com.netsensia.rivalchess.utils.mock

import com.netsensia.rivalchess.utils.`interface`.JmsSenderInterface
import com.netsensia.rivalchess.vie.model.EngineMatch

object MockJmsSender : JmsSenderInterface {
    val engineSettingsList = mutableListOf<EngineMatch>()

    override fun send(subject: String, message: Any) {
        val engineSettingsMessage = message as EngineMatch
        engineSettingsList.add(engineSettingsMessage)
    }
}