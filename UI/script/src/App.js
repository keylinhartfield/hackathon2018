import React, { Component } from 'react';
import './styles/sass/main.css';
import 'whatwg-fetch'
import PersonList from './Components/PersonList';

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
                   // console.log(response.json())
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
    return (
      <div className="App">
          <h1>The main App</h1>
        <PersonList personList={this.state.personList}/>

      </div>
    );
  }
}

export default App;
