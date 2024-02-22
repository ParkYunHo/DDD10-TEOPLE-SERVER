package com.ddd.teople.bootstrap.api.user

import com.ddd.teople.bootstrap.BootstrapApplicationTest
import io.kotest.core.spec.style.BehaviorSpec
import org.slf4j.LoggerFactory
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.util.LinkedMultiValueMap


@SpringBootTest(classes = [BootstrapApplicationTest::class])
@AutoConfigureMockMvc
@ActiveProfiles("test")
class UserControllerTest(
    private val mockMvc: MockMvc,
): BehaviorSpec({
    val log = LoggerFactory.getLogger(this::class.java)

    Given("먼저, 성공") {
        val params = LinkedMultiValueMap<String, String>().apply {
            add("nickName", "TEST_NICK_NAME22")
            add("birth", "20240222")
            add("anniversary", "20240223")

//            add("coupleCode", "654Dd3811")
        }

        When("만약,") {
            mockMvc.perform(
                MockMvcRequestBuilders.post("/user")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .params(params)
            ).andDo(MockMvcResultHandlers.print()).andReturn()
        }
    }
})