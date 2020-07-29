import React from 'react';
import Axios from 'axios';
import {Badge,Container} from 'react-bootstrap';

class TestingCount extends React.Component{
    constructor()
    {
        super();
        this.state={
            myObj:{}
        }
    }

    componentDidMount()
    {
        Axios.get('http:\\localhost:8080\getTotalTesting').then(response=>{
            this.setState({
                myObj:response.data
                
            });
            console.log(response.data)
            console.log(this.state.myObj)
        });
    }


    render()
    {
        return(
            <div style={{paddingLeft:100}}>
                <h4>Total samples tested until now:</h4>
            <h3><Badge variant="primary">{this.state.myObj.SamplesTestedToday}</Badge></h3>
            <h4>Samples tested today:</h4>
            <h3><Badge variant="success">{this.state.mainData.SamplesTestedTillToday}</Badge></h3>
            </div>
        )
    }
}

export default TestingCount;