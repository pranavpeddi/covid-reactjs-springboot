import React from 'react';
import {Container,Badge,Row,Col} from 'react-bootstrap';
import Axios from 'axios';
import CovidTable from './CovidTable'
import TestingCount from './TestingCount'



class Card extends React.Component{
    constructor()
    {
        super();
        this.state={}
    }
}
class Main extends React.Component{
    constructor()
    {
        super();
        this.state={
            mainData:{}
        }

    }

    componentDidMount()
    {
        Axios.get('http://localhost:8080/getTotal').then(res=>{
            this.setState({mainData:res.data});
            
        })
    }


    
    render()
    {
        return(
            <div className="App" style={{paddingLeft:150,paddingTop:50,paddingRight:250}}>
          <Container fluid style={{paddingBottom:25}}>
          <Row>
          <Col>
            <h4>Total Confirmed:</h4>
            <h3><Badge variant="primary">{this.state.mainData.totalConfirmed}</Badge></h3>
            <h4>Total Recovered:</h4>
            <h3><Badge variant="success">{this.state.mainData.totalRecovered}</Badge></h3>
            <h4>Total Deaths:</h4>
            <h3><Badge variant="danger">{this.state.mainData.totalDeaths}</Badge></h3>
            <h4>Total Active:</h4>
            <h3><Badge variant="info">{this.state.mainData.totalConfirmed-this.state.mainData.totalRecovered}</Badge></h3>
            </Col>
           
            </Row>
          </Container>
          <h2 style={{paddingBottom:5}}>StateWise Data </h2>
          <CovidTable/>
          </div>
        );
    }
}

export default Main;
