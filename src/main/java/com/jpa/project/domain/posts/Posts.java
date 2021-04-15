package com.jpa.project.domain.posts;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
/*@NoArgsConstructor ->기본 생성자 자동추가 어노테이션
* ->public Posts(){} 같은 효과이다 */
@Getter
@NoArgsConstructor
@Entity
//Posts 클래스는 DB와 매칭 되는 클래스 이고,Entity라고도 부른다.
//실제 쿼리를 날리기 보다는 Entity 클래스의 수정을 통해 작업을 진행 한다 .
public class Posts {

//    id -> pk 필드이다 . GeneratedValue-> PK의 생성 규칙이다 .
//    스프링부트 2.0 부터는 GenerationType.AUTO.IDENTITY 옵션을 추가해야만 ->auto_increment가 된다.
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT" ,nullable = false)
    private String content;
    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}

