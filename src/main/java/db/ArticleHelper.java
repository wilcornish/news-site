package db;

import models.Article;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import java.util.List;

public class ArticleHelper {
    private static Transaction transaction;
    private static Session session;


    public static List getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Article> articles = null;
        try {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(Article.class);
            transaction.commit();
            cr.addOrder(Order.desc("date"));
            articles = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return articles;
    }



    public static List getSidebar() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Article> articles = null;
        try {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(Article.class);
            transaction.commit();
            cr.setFetchSize(4);
            cr.addOrder(Order.desc("date"));
            articles = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        for(int i = 0; i <= 3; i++ )
        articles.remove(i);
        return articles;
    }
}
