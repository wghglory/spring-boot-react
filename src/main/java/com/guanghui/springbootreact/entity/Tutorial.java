package com.guanghui.springbootreact.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity()
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//  Type definition error: [simple type, class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor]; nested exception is com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS) (through reference chain: com.guanghui.tutorial.model.Tutorial$HibernateProxy$sBbJgoiK[\"hibernateLaz
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  // binary object issue
@Table(name = "tutorials", uniqueConstraints = @UniqueConstraint(name = "title_unique", columnNames = "title"))
public class Tutorial {
    @Id
    @SequenceGenerator(
            name = "tutorials_sequence",
            sequenceName = "tutorials_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tutorials_sequence")
    private Long tutorialId;

    @Column(name = "title", nullable = false)
    private String title;
    private String description;
    private Boolean published;

    public Tutorial(String title, String description, Boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }
}
