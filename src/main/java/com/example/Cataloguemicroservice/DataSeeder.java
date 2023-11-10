package com.example.Cataloguemicroservice;

//import com.example.Cataloguemicroservice.Entities.Etiquette;
//import com.example.Cataloguemicroservice.Entities.Produit;
//import com.example.Cataloguemicroservice.Entities.Variety;
//import com.example.Cataloguemicroservice.Entities.Category;
//import com.example.Cataloguemicroservice.Repository.CatalogueRepository;
//import com.example.Cataloguemicroservice.Repository.CategoryRepository;
//import com.example.Cataloguemicroservice.Repository.EtiquetteRepository;
//import com.example.Cataloguemicroservice.Repository.ProduitRepository;
//import com.example.Cataloguemicroservice.Repository.VarietyRepository;
//import com.github.javafaker.Faker;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Component
public class DataSeeder
//        implements CommandLineRunner
{
//
//    private final ProduitRepository produitRepository;
//    private final CategoryRepository categoryRepository;
//    private final EtiquetteRepository etiquetteRepository;
//    private final VarietyRepository varietyRepository;
//    private final CatalogueRepository catalogueRepository;
//    private final Faker faker;
//
//    public DataSeeder(ProduitRepository produitRepository, CategoryRepository categoryRepository,
//                      EtiquetteRepository etiquetteRepository, VarietyRepository varietyRepository,
//                      CatalogueRepository catalogueRepository) {
//        this.produitRepository = produitRepository;
//        this.categoryRepository = categoryRepository;
//        this.etiquetteRepository = etiquetteRepository;
//        this.varietyRepository = varietyRepository;
//        this.catalogueRepository = catalogueRepository;
//        this.faker = new Faker();
//    }
//
//// ...
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Seed your database with dummy data manually
//
//        for (int i = 0; i < 10; i++) {
//            Category category = new Category();
//            category.setNomCategory(faker.food().ingredient());
//
//            Etiquette etiquette = new Etiquette();
//            etiquette.setNomEtiquette(faker.food().spice());
//
//            Produit produit = new Produit();
//            produit.setNomProduit(faker.food().dish());
//            produit.setPrixProduit(faker.number().randomDouble(2, 1, 100));
//
//            // Save associated entities first
//            categoryRepository.save(category);
//            etiquetteRepository.save(etiquette);
//
//            produit.setCategory(category);
//            produit.setEtiquette(etiquette);
//
//            Set<Variety> varieties = generateRandomVarieties();
//
//            // Save Variety entities before saving Produit
//            for (Variety variety : varieties) {
//                varietyRepository.save(variety);
//            }
//
//            produit.setVarieties(varieties);
//
//            // Save associated entities
//            category.setProduits(List.of(produit));
//            etiquette.setProduits(List.of(produit));
//
//            // No need to explicitly save the Variety entities here as they have been saved earlier.
//
//            // Save Produit
//            produitRepository.save(produit);
//        }
//
//        // Add more seeding logic if needed
//    }
//
//// ...
//
//
//    private Set<Variety> generateRandomVarieties() {
//        Set<Variety> varieties = new HashSet<>();
//        for (int i = 0; i < faker.random().nextInt(1, 4); i++) {
//            Variety variety = new Variety();
//            variety.setVarietyName(faker.food().ingredient());
//            varieties.add(variety);
//        }
//        return varieties;
//    }
}