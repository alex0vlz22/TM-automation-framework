package utils.enums;

public enum HomePageOptions {

    ADMIN("Admin", "", "viewAdminModule", "System users"),
    PIM("Pim", "", "viewPimModule", "Employee information"),
    LEAVE("Leave", "", "viewLeaveModule", "Leave list"),
    TIME("Time", "", "viewTimeModule", "Select Employee"),
    RECRUITMENT("Recruitment", "", "viewRecruitmentModule", "Candidates"),
    MY_INFO("My Info", "", "viewMyDetails", "Personal details"),
    PERFORMANCE("Performance", "", "viewPerformanceModule", "Employee Reviews"),
    DASHBOARD("Dashboard", "", "dashboard", "Launching Soon"),
    DIRECTORY("Directory", "", "viewDirectory", "Directory"),
    MAINTENANCE("Maintenance", "", "viewMaintenanceModule", "Administrator Access"),
    BUZZ("Buzz", "", "viewBuzz", "Launching Soon");

    private final String name, value, href, displayedTitle;

    HomePageOptions(String name, String value, String href, String displayedTitle) {
        this.name = name;
        this.value = value;
        this.href = href;
        this.displayedTitle = displayedTitle;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getLocator() {
        return href;
    }

    public String getDisplayedTitle() {
        return displayedTitle;
    }

    public HomePageOptions getByName(String name) {
        for (HomePageOptions homePageOptions : values()) {
            if (homePageOptions.getName().equalsIgnoreCase(name)) {
                return homePageOptions;
            }
        }
        return null;
    }

    public HomePageOptions getByOptionTitle(String title) {
        for (HomePageOptions homePageOptions : values()) {
            if (homePageOptions.getDisplayedTitle().equals(title)) {
                return homePageOptions;
            }
        }
        return null;
    }

}
