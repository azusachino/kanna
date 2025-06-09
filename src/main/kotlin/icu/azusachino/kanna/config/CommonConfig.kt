package icu.azusachino.kanna.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 *
 * @author haru
 * @date 2025/06/09 11:25
 */
@Configuration
class CommonConfig {

    @Bean
    fun sampleObject(): String {
        return ""
    }
}