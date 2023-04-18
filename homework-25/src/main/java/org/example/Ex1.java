package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Ex1 {
    public static void main(String[] args) {
        // Установка пути к драйверу для Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        // Создание экземпляра WebDriver для Chrome
        WebDriver driver = new ChromeDriver();

        // Установка неявного ожидания
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // Открытие страницы поиска Google
        driver.get("https://www.google.com/search");

        // Находим элемент поисковой строки и вводим ссылку на регистрацию Guinness World Records
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("https://www.guinnessworldrecords.com/account/register?");
        searchInput.submit();

        // Находим элемент результата поиска и выполняем действие MoveTo
        WebElement searchResult = driver.findElement(By.cssSelector("a[href='https://www.guinnessworldrecords.com/account/register']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(searchResult).perform();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Открываем найденный элемент в новом окне браузера в фоне
        String link = searchResult.getAttribute("href");
        String script = "window.open('" + link + "', '_blank');";
        ((JavascriptExecutor) driver).executeScript(script);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

// получаем список всех открытых окон
        Set<String> handles = driver.getWindowHandles();
// переключаемся на нужное окно
        for (String handle : handles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals("https://www.guinnessworldrecords.com/account/register? - Пошук Google")) {
                break;
            }
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        WebElement searchButton = driver.findElement(By.id("APjFqb"));
        searchButton.click();


        // Находим элемент поисковой строки и вводим ссылку на страницу AlertsDemo
        WebElement searchInput1 = driver.findElement(By.id("APjFqb"));
        searchInput1.clear();
        searchInput1.sendKeys("https://www.hyrtutorials.com/p/alertsdemo.html");
        searchInput1.submit();

        // Находим элемент результата поиска и выполняем действие MoveTo
        searchResult = driver.findElement(By.cssSelector("a[href='https://www.hyrtutorials.com/p/alertsdemo.html']"));
        actions = new Actions(driver);
        actions.moveToElement(searchResult).perform();

        // Открываем найденный элемент в новом окне браузера в фоне
        link = searchResult.getAttribute("href");
        script = "window.open('" + link + "', '_blank');";
        ((JavascriptExecutor) driver).executeScript(script);

        // Максимальное ожидание загрузки страницы в 10 секунд
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        // Переход на страницу https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");

        // Ожидаем загрузки страницы
        Duration timeoutDuration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration);
        wait.until(ExpectedConditions.titleContains("W3Schools Tryit Editor"));
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
        String expectedTitle = "W3Schools Tryit Editor";
        Set<String> handles1 = driver.getWindowHandles();

        for (String handle : handles1) {
            driver.switchTo().window(handle);
            String title = driver.getTitle();
            if (title.equals(expectedTitle)) {
                break;
            }
        }
// Находим фрейм по его индексу
        WebElement frame = driver.findElement(By.cssSelector("iframe[id='iframeResult']"));

        driver.switchTo().frame(frame);

// Теперь находим элемент внутри фрейма и взаимодействуем с ним
        WebElement textarea = driver.findElement(By.id("fname"));
        textarea.clear();
        textarea.sendKeys("Аніцька");

        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);

        WebElement textarea2 = driver.findElement(By.id("lname"));
        textarea2.clear();
        textarea2.sendKeys("Прус");

        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);

        WebElement submitButton = driver.findElement(By.cssSelector("input[value='Submit']"));
        submitButton.click();


        System.out.println("Note: This tutorial will not teach you how servers are processing input. Processing input is explained in our PHP tutorial.");

        WebElement frame5 = driver.findElement(By.cssSelector("iframe[id='iframeResult']"));

        driver.switchTo().frame(frame5);

        // Ввод сообщения в поле ввода консоли
        WebElement consoleInput = driver.findElement(By.cssSelector("div.ace_layer.ace_text-layer > textarea"));
        consoleInput.sendKeys("Note: This tutorial will not teach you how servers are processing input. Processing input is explained in our PHP tutorial.");

        // Неявное ожидание в 2 секунды
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // Переключение на окно страницы https://www.guinnessworldrecords.com/account/register?
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("a[href='https://www.guinnessworldrecords.com/account/register?']")).click();

        // Неявное ожидание в 2 секунды
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // Заполнение полей формы
        driver.findElement(By.id("LastName")).sendKeys("Prus");
        driver.findElement(By.id("FirstName")).sendKeys("Hanna");
        driver.findElement(By.id("DateOfBirthDay")).sendKeys("27");
        driver.findElement(By.id("DateOfBirthMonth")).sendKeys("08");

        // Неявное ожидание элементов на странице в течение 10 секунд
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        // Находим элемент для ввода года рождения, вводим текст "1993"
        WebElement yearInput = driver.findElement(By.id("DateOfBirthYear"));
        yearInput.sendKeys("1993");

        // Находим элемент для ввода email, вводим текст "meowmeow@mail.com"
        WebElement emailInput = driver.findElement(By.id("EmailAddress"));
        emailInput.sendKeys("meowmeow@mail.com");

        // Находим элемент для ввода подтверждения email, вводим текст "meowmeow@mail.com"
        WebElement confirmEmailInput = driver.findElement(By.id("ConfirmEmailAddress"));
        confirmEmailInput.sendKeys("meowmeow@mail.com");

        // Находим элемент для ввода пароля, вводим текст "meowmeow01"
        WebElement passwordInput = driver.findElement(By.id("Password"));
        passwordInput.sendKeys("meowmeow01");

        // Находим элемент для ввода подтверждения пароля, вводим текст "meowmeow02"
        WebElement confirmPasswordInput = driver.findElement(By.id("ConfirmPassword"));
        confirmPasswordInput.sendKeys("meowmeow02");

        // Находим элемент "Create a Password" и кликаем на него
        WebElement createPassword = driver.findElement(By.xpath("//h2[contains(text(), 'Create a Password')]"));
        createPassword.click();

        // Выводим сообщение об ошибке в консоль
        WebElement errorAlert = driver.findElement(By.xpath("//span[contains(text(), 'Confirm password') and contains(text(), 'Password') and contains(text(), 'not match')]"));
        System.out.println(errorAlert.getText());

        // Неявное ожидание 2 секунды
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Переключаемся на следующее окно браузера
        String currentWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        // Нажатие на кнопку alertBox
        WebElement alertBoxBtn = driver.findElement(By.id("alertBox"));
        alertBoxBtn.click();

        // Ожидание появления модального окна и нажатие кнопки "Ok"
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(2));
        Alert alert = wait1.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        // Вывод сообщения в консоль
        System.out.println("I am an alert box!");

        // Нажатие на кнопку confirmBox
        WebElement confirmBoxBtn = driver.findElement(By.id("confirmBox"));
        confirmBoxBtn.click();

        // Ожидание появления модального окна и нажатие кнопки "Cancel"
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();

        // Вывод сообщения в консоль
        System.out.println("Press a button!");

        // Нажатие на кнопку promptBox
        WebElement promptBoxBtn = driver.findElement(By.id("promptBox"));
        promptBoxBtn.click();

        // Ожидание появления модального окна, ввод текста и нажатие кнопки "Ok"
        alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("Final step of this task");
        alert.accept();

        // Вывод сообщения в консоль
        System.out.println("You entered text Final step of this task in prompt popup");

       /* // Закрытие браузера
        driver.quit();
*/
    }
}
