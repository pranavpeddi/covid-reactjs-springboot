import React from 'react';
import {Accordion,Container,Card} from 'react-bootstrap'
import CovidTable from './CovidTable'

class Acc extends React.Component{
   
    render()
    {
        return(
        
            <Container >
                <Accordion>
                    <Card>
                        <Card.Header>
                            <Accordion.Toggle variant="link" eventKey="0" >
                            <Card.Body><CovidTable/></Card.Body>

                            </Accordion.Toggle>
                        </Card.Header>
                    </Card>
                </Accordion>
            </Container>
        );
    }
}

export default Acc;