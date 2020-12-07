package com.example.demo.stepDefinitions;

import com.example.demo.model.Contract;
import com.example.demo.model.Subscriber;
import com.example.demo.repositories.SubscriberRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import okhttp3.OkHttpClient;
//import okhttp3.Response;
//import org.apache.http.HttpResponse;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

//import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.*;

public class StepDefinition  {

    //private OkHttpClient client = new OkHttpClient();
    //private Response response;

    @Resource
    private SubscriberRepository subscriberRepository;

    static class SubscriberEntity {

        static Subscriber getNewSubscriber(){
            String firstName = "Julien";
            String lastName = "Fritz";
            String address = "12 rue Pascal, 69000 Lyon";
            Subscriber jack = new Subscriber(firstName, lastName, address/*, new ArrayList<>()*/);
            return jack;
        }
    }
    //CloseableHttpClient httpClient = HttpClients.createDefault();

    String newAddress = "7 rue Gambetta, 75020 Paris";
    Subscriber subscriber;


    @Given("^un abonné avec une adresse principale en France$")
    public void un_abonné_avec_une_adresse_principale_en_france() {
        // Write code here that turns the phrase above into concrete actions
        subscriber = SubscriberEntity.getNewSubscriber();
        subscriberRepository.save(subscriber);

    }

    @When("^le conseiller modifie l'adresse de l'abonné$")
    public void le_conseiller_connecté_à_modifie_l_adresse_de_l_abonné() throws Throwable {
        subscriberRepository.updateSubscriberAddress(subscriber.getAddress(), newAddress);
        subscriber.setAddress(newAddress);
    }

    @Then("^la nouvelle adresse de l’abonné est enregistrée sur l'ensemble des contrats de l'abonné$")
    public void l_adresse_de_l_abonné_modifiée_est_enregistrée_sur_l_ensemble_des_contracts_de_l_abonné() throws Throwable {
        Subscriber s = subscriberRepository.findByLastName(subscriber.getLastName());
        // here we have to use a methode that give us all contract of a subscriber using his id
        /*
        List<Contract> list = subscriberRepository.getAllContract(id);
        for(Contract c : list){
            assertEquals(newAddress, c.getAddress());
        }
         */
        // then
        assertEquals(newAddress, s.getAddress());

    }

    @And("^un mouvement de modification d'adresse est crée avec la nouvelle adresse$")
    public void un_mouvement_de_modification_d_adresse_est_crée() throws Throwable {

        // here we will need to creat a repository for history modifications
        // And test if any new update was added to this table

        // using the mock server to test the request with more details on the specification could be that way

        /*stubFor(get(urlEqualTo("/changeAddress")).willReturn(aResponse().withBody("AddressChanged")));
        HttpGet request = new HttpGet("http://localhost:8080/changeAddress");
        HttpResponse httpResponse = httpClient.execute(request);
        String stringResponse = convertResponseToString(httpResponse);
        verify(getRequestedFor(urlEqualTo("/changeAddress")));
        assertEquals("AddressChanged", stringResponse);*/
    }

    /*private String convertResponseToString(HttpResponse response) throws IOException {
        InputStream responseStream = response.getEntity().getContent();
        Scanner scanner = new Scanner(responseStream, "UTF-8");
        String responseString = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return responseString;
    }*/

}
