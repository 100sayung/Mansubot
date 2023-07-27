package com.discord.mansubot.utils.repository;

import com.discord.mansubot.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandEntryRepository extends JpaRepository<CommandEntry, String> {
    // 별도의 메서드 선언 없이 JpaRepository를 상속하면 자동으로 CRUD 메서드를 상속받게 됩니다.
    // 만약 특별한 쿼리 메서드가 필요하다면 여기에 추가적으로 선언하면 됩니다.
}
