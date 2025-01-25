
```
# Data Visualization App

This is a web application built using the Shiny framework in R. The app allows users to upload CSV or Excel files, explore the dataset, and visualize the data using scatter plots, bar charts, and line graphs.

## Features

- File Upload: Users can upload their own CSV or Excel files to analyze and visualize the data. If no file is uploaded, the app defaults to the mtcars dataset.

- Variable Selection: Users can choose the X and Y variables for the plots from the available options in the dataset.

- Plot Types: Users can select from three different plot types: Scatter Plot, Bar Chart, and Line Graph. The plots are generated using the ggplot2 library.

- Summary Statistics: The app provides a summary table displaying the minimum, 1st quartile, median, mean, 3rd quartile, and maximum values for each variable in the dataset.

## Getting Started

To run the app locally, follow these steps:

1. Install R and RStudio, if not already installed.
2. Clone this GitHub repository.
3. Open the R project in RStudio.
4. Install the required packages by running the following command in the R console:

```
install.packages(c("shiny", "tidyverse", "viridis", "readxl"))
```

5. Run the app by executing the following command in the R console:

```
shiny::runApp()
```

6. The app will open in a web browser, and you can start exploring and visualizing your data.

## Dependencies

The app requires the following R packages:

- shiny
- tidyverse
- viridis
- readxl

These packages can be installed using the `install.packages()` function in R.

## About

This app was developed by Yamkela Macwili.

Feel free to use and modify this app to suit your needs. Contributions and suggestions are welcome!

```
