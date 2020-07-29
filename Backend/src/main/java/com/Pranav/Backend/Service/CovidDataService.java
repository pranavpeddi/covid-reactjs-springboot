package com.Pranav.Backend.Service;


import com.Pranav.Backend.Model.StateData;
import com.Pranav.Backend.Repository.StateDataRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CovidDataService {

    @Autowired
    private StateDataRepository stateDataRepository;




    public List<StateData> saveData() throws IOException
    {
        final String url="https://www.mygov.in/covid-19";
        Document document= Jsoup.connect(url).get();
        System.out.println(document.title());
        //#state-covid-data    #state-covid-data > tbody #state-covid-data > tbody > tr:nth-child(1)
        List<StateData> stList=new ArrayList<>();
        for(Element row:document.select("#state-covid-data tr"))
        {

           StateData stateData=new StateData();

            //names
            if(row.select("td:nth-child(1)").text().equals(""))
            {
                continue;
            }
            else
            {

                stateData.setName(row.select("td:nth-child(1)").text());
            }

            //confirmed

            if(row.select("td:nth-child(2)").text().equals(""))
            {
                continue;
            }
            else
            {

                stateData.setConfirmed(Long.parseLong(row.select("td:nth-child(2)").text().replaceAll(",","")));
            }

            //active
            if(row.select("td:nth-child(3)").text().equals(""))
            {
                continue;
            }
            else
            {
                stateData.setActive(Long.parseLong(row.select("td:nth-child(3)").text().replaceAll(",","")));
            }


            //active

            if(row.select("td:nth-child(4)").text().equals(""))
            {
                continue;
            }
            else
            {
                stateData.setRecovered(Long.parseLong(row.select("td:nth-child(4)").text().replaceAll(",","")));
            }



            //
            if(row.select("td:nth-child(5)").text().equals(""))
            {
                continue;
            }
            else
            {
                stateData.setDeaths(Long.parseLong(row.select("td:nth-child(5)").text().replaceAll(",","")));
            }


            //  st1.setRecovered(Long.parseLong(row.select("td:nth-child(4)").text().replaceAll(",","")));
            //  st1.setDeaths(Long.parseLong(row.select("td:nth-child(4)").text().replaceAll(",","")));

            stateData.setLocalDate(LocalDate.now());
            stList.add(stateData);
            stateDataRepository.save(stateData);
        }

     return stList;


    }


    public List<Map<String,Object>> getData()
    {
        LocalDate localDate=LocalDate.now();
        return stateDataRepository.getData(localDate);
    }


    public Map<String,Object> getTotalDetails()
    {
          List<StateData> stateDataList=stateDataRepository.getAllByLocalDate(LocalDate.now());

          Map<String,Object> dataMap=new HashMap<>();
          long totalConfirmed=0l;
          long totalDeaths=0l;
          long totalRecovered=0l;
          for(StateData std:stateDataList)
          {
              totalConfirmed+=std.getConfirmed();
              totalDeaths+=std.getDeaths();
              totalRecovered+=std.getRecovered();
          }
          double totalRecoveryPercentage=((totalRecovered*100/totalConfirmed));
          double
                  totalDeathPercentage=((totalDeaths*100/totalConfirmed));



          dataMap.put("totalConfirmed",totalConfirmed);
          dataMap.put("totalDeaths",totalDeaths);
          dataMap.put("totalRecovered",totalRecovered);

         dataMap.put("recoveryPercentage",totalRecoveryPercentage);
          dataMap.put("deathPercentage",totalDeathPercentage);

          return dataMap;
    }

    public Map<String,String> getTestingCount() throws IOException
    {
        final String url="https://www.mygov.in/covid-19";
        Document doc= Jsoup.connect(url).get();
        Elements links=doc.getElementsByClass("testing_result");
        Map<String,String> testingMap=new HashMap<>();

        for(Element ele: links)
        {

            testingMap.put("SamplesTestedTillToday",ele.getElementsByClass("testing_count").text());
        }


        Elements links2=doc.getElementsByClass("testing_sample");

        for(Element ele: links2)
        {
            testingMap.put("SamplesTestedToday",ele.getElementsByClass("testing_count").text());
        }
        return testingMap;
    }




    }





