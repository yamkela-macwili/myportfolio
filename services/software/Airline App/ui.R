library(shiny)

# Define UI function
ui <- fluidPage(
  tags$head(
    tags$style(
      HTML("
        .title-panel {
          margin-bottom: 100px;
        }
        
        .sidebar-layout > .sidebar-panel {
          margin-top: 20px;
        }
        
        .summary-output {
          margin-top: 20px;
          font-weight: bold;
          color: red;
        }
        
        .summary-title {
          font-weight: bold;
          font-size: 16px;
          margin-top: 10px;
        }
      ")
    )
  ),
  titlePanel(
    h1("Data Visualization App",
       class = "title-panel",
       style = "color: blue; font-weight: bold; text-align: center;")
  ),
  sidebarLayout(
    sidebarPanel(
      # Add input controls here (e.g., file upload or dropdown menus)
      fileInput("file", "Upload CSV | XLS/XLSX file"),
      selectInput("xVar", "Select X Variable", choices = NULL),
      selectInput("yVar", "Select Y Variable", choices = NULL),
      selectInput("plotType", "Select Plot Type", choices = c("Scatter Plot", "Bar Chart", "Line Graph")),
      # Add more input controls as needed
      
      # Summary section
      tags$div(
        class = "summary-section",
        tags$h3("Summary", class = "summary-title"),
        tableOutput("summaryOutput")
      )
    ),
    mainPanel(
      # Display the head of the dataset
      tableOutput("headData"),
      
      # Add plot or visualization area here
      plotOutput("plot"),
      
      # Variable selection
      verbatimTextOutput("selectedVariables")
    )
  )
)
