import React, { Component } from 'react';



class PersonItem extends Component {



    render() {
        return (
            <div className="PersonItem">
                <ul>
                    <li>First Name: {this.props.person.firstname}</li>
                    <li>Last name: {this.props.person.lastname}</li>
                    <li>PhotoId: {this.props.person.photoId} </li>
                </ul>



            </div>
        );
    }
}

export default PersonItem;
