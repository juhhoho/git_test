package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    /*
    spring boot gives standard option for CRUD
    method:

    save(S entity): 엔티티를 저장하거나 업데이트합니다.
    findById(ID id): 주어진 ID로 엔티티를 찾습니다.
    existsById(ID id): 주어진 ID로 엔티티가 존재하는지 여부를 확인합니다.
    findAll(): 모든 엔티티를 조회합니다.
    findAllById(Iterable<ID> ids): 주어진 ID 목록에 해당하는 모든 엔티티를 조회합니다.
    count(): 저장된 엔티티의 총 개수를 반환합니다.
    deleteById(ID id): 주어진 ID로 엔티티를 삭제합니다.
    delete(T entity): 주어진 엔티티를 삭제합니다.
    deleteAll(): 모든 엔티티를 삭제합니다.
    이 외의 다른 기능을 추가하고 싶다면 규칙에 맞는 메서드를 추가해야 함.

    1. findBy로 시작
	   -> 쿼리를 요청하는 메서드 임을 알림
    2. countBy로 시작
       -> 쿼리 결과 레코드 수를 요청하는 메서드 임을 알림
     */
}
