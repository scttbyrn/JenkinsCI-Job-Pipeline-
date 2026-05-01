package testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import abstractTest.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.CurrencyPage;
import pageObject.LandingPage;
import pageObject.TripPage;

public class Testing extends BasePage {

	@Test (dataProvider = "getDiscountData", groups = {"Regression"})
	public void testCase1(String dType) {

		landingpage.gotoWebsite();
		TripPage trippage = landingpage.selectDiscount(dType);
		CurrencyPage currencypage = trippage.selectTrip();
		currencypage.selectCurrency();

	}

	@Test (groups = {"Sanity"})
	public void testCase2() {

		landingpage.gotoWebsite();
		TripPage trippage = new TripPage(driver);
		trippage.selectTrip();

	}

	@Test (groups = {"Smoke"})
	public void testCase3() {

		landingpage.gotoWebsite();
		CurrencyPage currencypage = new CurrencyPage(driver);
		currencypage.selectCurrency();

	}



	@DataProvider
	public Object[][] getDiscountData() {

		return new Object [][] {
			{"Family and Friends"},
			{"Senior Citizen"},
			{"Indian Armed Forces"},
			{"Student"},
			{"Unaccompanied Minor"},
		};

	}


	/**
	 * JENKINS CICD PIPELINE
	 * 
	 * pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/scttbyrn/ExtentReport_Parallel.git'
            }
        }

        stage('Smoke Testing') {
            steps {
                echo 'This is Smoke Test'
                bat 'mvn test -PSmoke -Dbrowser=edge'
            }
        }

        stage('Regression Testing') {
            steps {
                echo 'This is Regression Test'
                bat 'mvn test -PRegression -Dbrowser=chrome'
            }
        }
    }

    post {
        success {
            echo 'Pipeline Successful'
        }
        failure {
            echo 'Pipeline Failed'
        }
    }
}
	 * 
	 * **/



}
