package uk.co.datadisk.jpa1.repositories;

import org.springframework.stereotype.Repository;
import uk.co.datadisk.jpa1.entities.Gender;
import uk.co.datadisk.jpa1.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserCriteriaRepository {

    private EntityManager em;

    public UserCriteriaRepository(EntityManager em) {
        this.em = em;
    }

    public User findUser(String username) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);

        criteria.where(builder.equal(root.get("username"), username));

        User user = em
                .createQuery(criteria)
                .getSingleResult();

        return user;

    }

    public User findUserPredicate(String username, Gender gender) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);

        List<Predicate> predicates = new ArrayList<>();

        // use IF or SWITCH statements to build the query with as many where clauses as you like
        Predicate predicate1 = builder.equal(root.get("username"), username);
        Predicate predicate2 = builder.equal(root.get("gender"), gender);
        predicates.add(predicate1);
        predicates.add(predicate2);

        criteria.select(root).where(predicates.toArray(new Predicate[]{}));

        TypedQuery<User> q = em.createQuery(criteria);

        return q.getSingleResult();

    }
}
