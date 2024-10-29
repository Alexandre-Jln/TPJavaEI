package com.example.demo.service;

import com.example.demo.entity.ArticleEntity;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * Classe permettant d'insérer des données dans l'application.
 */
@Service
@Transactional
public class InitData implements ApplicationListener<ApplicationReadyEvent> {

    private EntityManager entityManager;

    public InitData(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        insertTestData();
    }

    private void insertTestData() {
        ArticleEntity a1 = createArticle("Les conserves de viande de licorne", 22.98, "https://static.hitek.fr/img/actualite/2016/08/26/41gn6tpvqtl.jpg");
        ArticleEntity a2 = createArticle("Wenger Couteau suisse géant", 46.39, "https://static.hitek.fr/img/actualite/2016/08/26/61abqa-gt8s-sx522.jpg");
        ArticleEntity a3 = createArticle("PAPIER TOILETTE DONALD TRUMP", 4.99, "https://static.hitek.fr/img/actualite/2016/08/26/61cb4xnrbol-sx522.jpg");
        ArticleEntity a4 = createArticle("Grattoir pour Chat en Forme de Platine de DJ", 23.14, "https://static.hitek.fr/img/actualite/2016/08/26/61griray9-l-sx522.jpg");
        ArticleEntity a5 = createArticle("Jay nothing", 2, "https://static.hitek.fr/img/actualite/2016/08/26/61vu-jqjygl-sy679.jpg");
        ArticleEntity a6 = createArticle("UN AFFINEUR DE VISAGE", 52, "https://static.hitek.fr/img/actualite/2016/08/26/w_41r-1yapf5l.jpg");
    }

    private ArticleEntity createArticle(String libelle, double prix, String imageUrl) {
        ArticleEntity a1 = new ArticleEntity();
        a1.setLibelle(libelle);
        a1.setPrix(prix);
        a1.setImageUrl(imageUrl);
        entityManager.persist(a1);
        return a1;
    }

}
