library(shiny)
library(tidyverse)
library(viridis)

# Define server function
server <- function(input, output, session) {
  # Initialize dataset as NULL
  dataset <- reactiveVal(NULL)
  
  # Update dataset when the file is uploaded or on initial run
  observeEvent(input$file, {
    req(input$file)
    if (tolower(tools::file_ext(input$file$name)) == "csv") {
      dataset(read.csv(input$file$datapath))
    } else if (tolower(tools::file_ext(input$file$name)) %in% c("xls", "xlsx")) {
      dataset(readxl::read_excel(input$file$datapath))
    }
  }, once = TRUE)  # Run only once on initial run
  
  # If no file is uploaded, show mtcars dataset by default
  observe({
    if (is.null(input$file) && is.null(dataset())) {
      dataset(mtcars)
    }
  })
  
  # Update variable choices based on the uploaded dataset
  observeEvent(dataset(), {
    req(dataset())
    updateSelectInput(session, "xVar", choices = colnames(dataset()))
    updateSelectInput(session, "yVar", choices = colnames(dataset()))
  })
  
  # Display the head of the dataset in the main panel
  output$headData <- renderTable({
    req(dataset())
    head(dataset())
  })
  
  # Calculate summary statistics of the dataset
  datasetSummary <- reactive({
    req(dataset())
    summaryData <- as.data.frame(t(apply(dataset(), 2, function(x) {
      c(min(x), quantile(x, probs = c(0.25, 0.5, 0.75)), max(x))
    })))
    colnames(summaryData) <- c("Min", "1st Q", "Median", "3rd Q", "Max")
    summaryData
  })
  
  # Display the summary table
  output$summaryOutput <- renderTable({
    req(dataset())
    datasetSummary()
  })
  
  # Render the plot based on the selected plot type and variables
  output$plot <- renderPlot({
    req(input$plotType, input$xVar, input$yVar, dataset())
    
    plot_title <- paste(input$xVar, "vs", input$yVar)
    
    if (input$plotType == "Scatter Plot") {
      # Generate a scatter plot with a line based on user inputs or dataset
      dataset() %>%
        ggplot(aes_string(x = input$xVar, y = input$yVar)) +
        geom_point(color = viridis(1)) +
        geom_smooth(method = "lm", se = FALSE, color = "red") +
        labs(x = input$xVar, y = input$yVar, title = plot_title) +
        theme_minimal() +
        theme(
          plot.title = element_text(hjust = 0.5, face = "bold", size = 16),
          axis.title = element_text(face = "bold", size = 14),
          axis.text = element_text(size = 12, face = "bold")
        )
    } else if (input$plotType == "Bar Chart") {
      # Generate a bar chart based on user inputs or dataset
      dataset() %>%
        ggplot(aes_string(x = input$xVar, y = input$yVar, fill = input$yVar)) +
        geom_col() +
        scale_fill_viridis(option = "D") +
        labs(x = input$xVar, y = input$yVar, title = plot_title) +
        theme_minimal() +
        theme(
          plot.title = element_text(hjust = 0.5, face = "bold", size = 16),
          axis.title = element_text(face = "bold", size = 14),
          axis.text = element_text(size = 12, face = "bold")
        )
    } else if (input$plotType == "Line Graph") {
      # Generate a line graph based on user inputs or dataset
      dataset() %>%
        ggplot(aes_string(x = input$xVar, y = input$yVar, color = input$yVar)) +
        geom_line(size = 1) +
        scale_color_viridis(option = "D") +
        labs(x = input$xVar, y = input$yVar, title = plot_title) +
        theme_minimal() +
        theme(
          plot.title = element_text(hjust = 0.5, face = "bold", size = 16),
          axis.title = element_text(face = "bold", size = 14),
          axis.text = element_text(size = 12, face = "bold")
        )
    }
  })
  
  # Show list of variables when a plot type is selected
  output$selectedVariables <- renderPrint({
    if (!is.null(dataset())) {
      colnames(dataset())
    }
  })
}
