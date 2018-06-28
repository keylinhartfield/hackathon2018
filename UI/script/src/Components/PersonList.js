import React, { Component } from 'react';

import PersonItem from './PersonItem';


class PersonList extends Component {



    render() {
        let personItems;
        if(this.props.personList){
            personItems = this.props.personList.map(person =>{
                return(
                    <PersonItem key={person.id} person={person} />
                );
            });
        }
        return (
            <div className="PersonList">
                {personItems}
            </div>
        );
    }
}

export default PersonList;