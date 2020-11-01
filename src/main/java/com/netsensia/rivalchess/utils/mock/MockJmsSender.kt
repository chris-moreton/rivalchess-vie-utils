package com.netsensia.rivalchess.utils.mock

import com.netsensia.rivalchess.utils.interfaces.JmsServiceInterface
import com.netsensia.rivalchess.vie.model.EngineMatch

object MockJmsSender : JmsServiceInterface {
    val engineSettingsList = mutableListOf<EngineMatch>()

    override fun send(subject: String, message: Any) {
        val engineSettingsMessage = message as EngineMatch
        engineSettingsList.add(engineSettingsMessage)
    }

    override fun receive(subject: String): String {
        return "IAmAMock"
    }
}