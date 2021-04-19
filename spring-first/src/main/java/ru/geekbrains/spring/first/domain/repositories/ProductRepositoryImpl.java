package ru.geekbrains.spring.first.domain.repositories;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.first.HibernateSessionFactory;
import ru.geekbrains.spring.first.domain.model.Product;

import java.util.List;
import java.util.Optional;

@Component()
@Scope("singleton")
public class ProductRepositoryImpl implements ProductRepository {
    private final HibernateSessionFactory sessionFactory;

    @Autowired
    public ProductRepositoryImpl(HibernateSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Optional<Product> getById(int id) {
        try (Session session = sessionFactory.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return Optional.of(product);
        }
    }

    public Product saveOrUpdate(Product product) {
        try (Session session = this.sessionFactory.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
            return product;
        }
    }

    public void delete(Product product) {
        try (Session session = this.sessionFactory.getSession()) {
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    public List<Product> getProducts() {
        try (Session session = this.sessionFactory.getSession()) {
            session.beginTransaction();
            List<Product> products = (List<Product>) session.createQuery(" from Product").list();
            session.getTransaction().commit();
            return products;
        }
    }
}
