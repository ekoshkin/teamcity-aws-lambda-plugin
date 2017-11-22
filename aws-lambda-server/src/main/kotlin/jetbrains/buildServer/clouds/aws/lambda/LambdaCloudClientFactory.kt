package jetbrains.buildServer.clouds.aws.lambda

import jetbrains.buildServer.clouds.CloudClientEx
import jetbrains.buildServer.clouds.CloudClientFactory
import jetbrains.buildServer.clouds.CloudClientParameters
import jetbrains.buildServer.clouds.CloudState
import jetbrains.buildServer.serverSide.AgentDescription
import jetbrains.buildServer.serverSide.PropertiesProcessor

/**
 * Created by Evgeniy Koshkin (evgeniy.koshkin@jetbrains.com) on 23.11.17.
 */
class LambdaCloudClientFactory : CloudClientFactory {
    override fun getCloudCode(): String {
        return "awslambda"
    }

    override fun getDisplayName(): String {
        return "Amazon Lambda"
    }

    override fun getEditProfileUrl(): String? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getInitialParameterValues(): MutableMap<String, String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun canBeAgentOfType(description: AgentDescription): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createNewClient(state: CloudState, params: CloudClientParameters): CloudClientEx {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPropertiesProcessor(): PropertiesProcessor {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}