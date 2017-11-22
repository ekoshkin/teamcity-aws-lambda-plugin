package jetbrains.buildServer.clouds.aws.lambda

import jetbrains.buildServer.clouds.*
import jetbrains.buildServer.serverSide.AgentDescription
import jetbrains.buildServer.serverSide.InvalidProperty
import jetbrains.buildServer.serverSide.PropertiesProcessor
import jetbrains.buildServer.serverSide.ServerSettings
import jetbrains.buildServer.util.amazon.AWSCommonParams
import jetbrains.buildServer.web.openapi.PluginDescriptor
import java.util.*

/**
 * Created by Evgeniy Koshkin (evgeniy.koshkin@jetbrains.com) on 23.11.17.
 */
class LambdaCloudClientFactory(cloudRegister: CloudRegistrar,
                               pluginDescriptor: PluginDescriptor,
                               private val serverSettings: ServerSettings) : CloudClientFactory {
    private val editUrl = pluginDescriptor.getPluginResourcesPath("editLambda.html")

    init {
        cloudRegister.registerCloudFactory(this)
    }

    override fun getCloudCode(): String {
        return "awslambda"
    }

    override fun getDisplayName(): String {
        return "Amazon Lambda"
    }

    override fun getEditProfileUrl(): String? {
        return editUrl
    }

    override fun getInitialParameterValues(): MutableMap<String, String> {
        val result = HashMap<String, String>()
        result.putAll(AWSCommonParams.getDefaults(serverSettings.serverUUID))
        return result
    }

    override fun getPropertiesProcessor(): PropertiesProcessor {
        return PropertiesProcessor { properties ->
            val invalids = ArrayList<InvalidProperty>()
            for (e in AWSCommonParams.validate(properties!!, false)) {
                invalids.add(InvalidProperty(e.key, e.value))
            }
            invalids
        }
    }

    override fun canBeAgentOfType(description: AgentDescription): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createNewClient(state: CloudState, params: CloudClientParameters): CloudClientEx {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}