# AverageStockPrice

This project uses Alpha Vantage API to create a simple web service that returns average and individual closing prices of a stock over ndays.

To deploy this project on a vanilla kubernetes environment (I have tested this on minikube), download "averagestockprice.yaml" and run the following command in your terminal/shell:

  $ cd path/to/yaml/download
  $ kubectl create -f averagestockprice.yaml
  
This should create a pod that runs the .jar for this project. To access it, go to localhost:8080 on your browser.
