import React, { Component } from 'react';
import './styles/sass/main.css';
import 'whatwg-fetch'
import PersonList from './Components/PersonList';
import Exist from './Components/Exist';

class App extends Component {

    constructor(){
        super();
        this.state={
            personList: [],

        }
    }
    componentDidMount() {
        fetch('http://localhost:6002/user-management/list')
            .then(function(response){
                if(response.status >= 400){
                    throw new Error("Bad response from server");
                }
                else{

                    return response.json();
                }

            }).then(data => data.map(user => (
                {
                    firstname: `${user.firstname}`,
                    lastname: `${user.lastname}`,
                    photoId: `${user.photoId}`
                 }
        ))).then(personList =>this.setState({
            personList
        }))


    }

  render() {
    const arrayLength = this.state.personList.length;
    console.log(arrayLength);

    if(arrayLength >=5)
    {
        return (
              <div className="App">
                  <h1>The main App</h1>
                <PersonList personList={this.state.personList}/>

              </div>
            );
    }
    else{
    return (
             <div className="App">

                 <Exist />

             </div>
          );
    }

  }
}

export default App;
