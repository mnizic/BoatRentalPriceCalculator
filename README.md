# Task name:
Boat rental price calculator according to a given price list.

# Task description:
Based on the attached XLS file, create a suitable object-oriented model for storing the values loaded from the attached CSV file.
The attached CSV price list defines data about the boat (ID, Name, Year), as well as corresponding WEEKLY prices for certain periods of the year.
After the price list is loaded, calculate the rental price for the defined boat ID, departure date, and rental duration. Boat ID, departure date, and rental duration are defined as parameters when calling the application.

So the ultimate goal is that by calling the command "java -jar project.jar 2 20.06.2021 5", the program returns the calculated rental price for the boat with ID 2 for the departure date of 20.06.2021 and rental duration of 5 days.

# Notes:

* 2 files are attached to the email: XLS and CSV. XLS contains 2 sheets: Explanation of each field/column in the price list and the appearance of the CSV file.
* Columns in the CSV file are separated by a ; delimiter
* The structure of the price list is considered fixed, i.e., there are always only 3 fields for describing the boat and we have 4 columns for price periods as an example. The number of columns for price periods is not fixed, and the data loading from the file needs to be adapted to a variable number of price period columns, and the object-oriented model must be set up in a way that accommodates a variable number of price periods.
* In the first row of the CSV file, the first 3 columns are empty, followed by the periods for which rental prices are defined. The period is defined in the date format from - to.
* An arbitrary number of rows/boats in the price list can be expected.
