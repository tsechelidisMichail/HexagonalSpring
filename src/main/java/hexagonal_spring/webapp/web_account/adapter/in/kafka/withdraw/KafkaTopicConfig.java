package hexagonal_spring.webapp.web_account.adapter.in.kafka.withdraw;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
@Configuration
class KafkaTopicConfig {
    @Bean
    public NewTopic withdrawTopic() {
        return TopicBuilder.name("withdraw-kafka")
                .build();
    }
}
