package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtil;

public class POM_SortUser {

	private WebDriver driver;

	public POM_SortUser(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "/html/body/app-root/app-user/div/mat-card/mat-card-title/div[1]")
	WebElement UserPageTitle;

	@FindBy(xpath = "/html/body/app-root/app-user/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[2]")
	public WebElement idSortIcon;
	@FindBy(xpath = "//p-table/div/div[1]/table/thead/tr/th[2]/p-sorticon/i[@class='p-sortable-column-icon pi pi-fw pi-sort-amount-up-alt'] ")
	public WebElement idSortIcon_Up;
	@FindBy(xpath = "//p-table/div/div[1]/table/thead/tr/th[2]/p-sorticon/i[@class='p-sortable-column-icon pi pi-fw pi-sort-amount-down'] ")
	public WebElement idSortIcon_Down;

	// @FindBy(xpath = "//div/table/tbody/tr[@class='ng-star-inserted']/td[2]")
	@FindBy(xpath = "//tr[@class='ng-star-inserted']/td[2]")
	public List<WebElement> UserIds;

	@FindBy(xpath = "//p-table/div/div[1]/table/thead/tr/th[3]")
	public WebElement NameSortIcon;
	@FindBy(xpath = "//p-table/div/div[1]/table/thead/tr/th[3]/p-sorticon/i[@class='p-sortable-column-icon pi pi-fw pi-sort-amount-up-alt']")
	public WebElement NameSortIcon_Up;
	@FindBy(xpath = "//p-table/div/div[1]/table/thead/tr/th[3]/p-sorticon/i[@class='p-sortable-column-icon pi pi-fw pi-sort-amount-down']")
	public WebElement NameSortIcon_Down;

	@FindBy(xpath = "//tr[@class='ng-star-inserted']/td[3]")
	public List<WebElement> UserNames;

	@FindBy(xpath = "//p-table/div/div[1]/table/thead/tr/th[4]")
	public WebElement LocationSortIcon;
	@FindBy(xpath = "//p-table/div/div[1]/table/thead/tr/th[4]/p-sorticon/i[@class='p-sortable-column-icon pi pi-fw pi-sort-amount-up-alt']")
	public WebElement LocationSortIcon_Up;
	@FindBy(xpath = "//p-table/div/div[1]/table/thead/tr/th[4]/p-sorticon/i[@class='p-sortable-column-icon pi pi-fw pi-sort-amount-down']")
	public WebElement LocationSortIcon_Down;

	@FindBy(xpath = "//tr[@class='ng-star-inserted']/td[4]")
	public List<WebElement> UserLocations;

	@FindBy(xpath = "//p-table/div/div[1]/table/thead/tr/th[5]")
	public WebElement PhoneNumberSortIcon;
	@FindBy(xpath = "//p-table/div/div[1]/table/thead/tr/th[5]/p-sorticon/i[@class='p-sortable-column-icon pi pi-fw pi-sort-amount-up-alt']")
	public WebElement PhoneNumberSortIcon_Up;
	@FindBy(xpath = "//p-table/div/div[1]/table/thead/tr/th[5]/p-sorticon/i[@class='p-sortable-column-icon pi pi-fw pi-sort-amount-down'] ")
	public WebElement PhoneNumberSortIcon_Down;

	@FindBy(xpath = "//tr[@class='ng-star-inserted']/td[5]")
	public List<WebElement> UserPhoneNumbers;

	public String getUserPageTitle() {
		return UserPageTitle.getText();

	}

	public void clickIdSortIcon() {
		ElementUtil.clickOnElement(driver, idSortIcon, 10);

	}

	public boolean UserDetailsSortedById(WebElement element) {
		if (element == idSortIcon_Up) {
			for (int i = 0; i <= UserIds.size(); i++) {
				if (UserIds.get(i).getText().compareTo(UserIds.get(i + 1).getText()) > 0) {
					return false;
				}
			}
			return true;

		} else if (element == idSortIcon_Down) {
			for (int i = 0; i <= UserIds.size(); i++) {
				if (UserIds.get(i).getText().compareTo(UserIds.get(i + 1).getText()) < 0) {
					return false;
				}
			}
			return true;
		}
		return true;
	}

	public void clickNameSortIcon() {
		ElementUtil.clickOnElement(driver, NameSortIcon, 10);

	}

	public boolean UserDetailsSortByName(WebElement element) {
		if (element == NameSortIcon_Up) {
			for (int i = 0; i <= UserNames.size(); i++) {
				if (UserNames.get(i).getText().compareTo(UserNames.get(i + 1).getText()) > 0) {
					return false;
				}
			}
			return true;

		} else if (element == NameSortIcon_Down) {
			for (int i = 0; i <= UserNames.size(); i++) {
				if (UserNames.get(i).getText().compareTo(UserNames.get(i + 1).getText()) < 0) {
					return false;
				}
			}
			return true;
		}
		return true;

	}

	public void clickLocatioSortIcon() {
		ElementUtil.clickOnElement(driver, LocationSortIcon, 10);

	}

	public boolean UserDetailsSortByLocation(WebElement element) {
		if (element == LocationSortIcon_Up) {
			for (int i = 0; i <= UserLocations.size(); i++) {
				if (UserLocations.get(i).getText().compareTo(UserLocations.get(i + 1).getText()) > 0) {
					return false;
				}
			}
			return true;

		} else if (element == LocationSortIcon_Down) {
			for (int i = 0; i <= UserLocations.size(); i++) {
				if (UserLocations.get(i).getText().compareTo(UserLocations.get(i + 1).getText()) < 0) {
					return false;
				}
			}
			return true;
		}
		return true;

	}

	public void clickPhoneNumberSortIcon() {
		ElementUtil.clickOnElement(driver, PhoneNumberSortIcon, 10);

	}

	public boolean UserDetailsSortByPhoneNumber(WebElement element) {
		if (element == PhoneNumberSortIcon_Up) {
			for (int i = 0; i < UserPhoneNumbers.size(); i++) {
				if (UserPhoneNumbers.get(i).getText().compareTo(UserLocations.get(i + 1).getText()) > 0) {
					return false;
				}
				return true;
			}
		} else if (element == PhoneNumberSortIcon_Down) {
			for (int i = 0; i < UserPhoneNumbers.size(); i++) {
				if (UserPhoneNumbers.get(i).getText().compareTo(UserLocations.get(i + 1).getText()) < 0) {
					return false;
				}
				return true;
			}
		}
		return true;
	}

}