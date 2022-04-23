import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Navigate, Route} from 'react-router-dom';
import Books from '../Books/BookList/books';
import Header from '../Header/header';
import BookAdd from '../Books/BookAdd/bookAdd';
import BookEdit from "../Books/BookEdit/bookEdit";
import Countries from "../Countries/countries";
import ELibService from "../../repository/eLibRepository";
import Authors from "../Authors/authors";


class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      authors: [],
      books: [],
      countries: [],
      selectedBook: {}
    }
  }

  render() {
    return (
        <Router>
          <Header/>
          <main>
            <div className="container">

              <Navigate to={"/books"}/>
                {/*<Route path={"/authors"} exact render={() =>*/}
                {/*    <Authors authors={this.state.authors}/>}/>*/}
                {/*<Route path={"/countries"} exact render={() =>*/}
                {/*    <Countries countries={this.state.countries}/>}/>*/}

                {/*<Route path={"/books/add"} exact render={() =>*/}
                {/*    <BookAdd authors={this.state.authors}*/}
                {/*             onAddBook={this.addBook}/>}/>*/}
                {/*<Route path={"/books/edit/:id"} exact render={() =>*/}
                {/*    <BookEdit authors={this.state.authors}*/}
                {/*              onEditBook={this.editBook}*/}
                {/*              book={this.state.selectedBook}/>}/>*/}

                {/*<Route path={"/books"} exact render={() =>*/}
                {/*    <Books books={this.state.books}*/}
                {/*              onDelete={this.deleteBook}*/}
                {/*              onEdit={this.getBook}/>}/>*/}
            </div>
          </main>
        </Router>
    );
  }

  componentDidMount() {
    this.loadAuthors();
    this.loadCountries();
    this.loadBooks();
  }

  loadAuthors = () => {
    ELibService.fetchAuthors()
        .then((data) => {
          this.setState({
            authors: data.data
          })
        });
  }

  loadBooks = () => {
      ELibService.fetchBooks()
        .then((data) => {
          this.setState({
            books: data.data
          })
        });
  }

  loadCountries = () => {
      ELibService.fetchCountries()
        .then((data) => {
          this.setState({
            countries: data.data
          })
        });
  }

  deleteProduct = (id) => {
      ELibService.deleteBook(id)
        .then(() => {
          this.loadBooks();
        });
  }

  addBook = (name, author, availableCopies) => {
      ELibService.addBook(name, author, availableCopies)
        .then(() => {
          this.loadBooks();
        });
  }

  getBook = (id) => {
      ELibService.getBook(id)
        .then((data) => {
          this.setState({
            selectedBook: data.data
          })
        })
  }

  editBook = (id, name, author, availableCopies) => {
      ELibService.editBook(id, name, author, availableCopies)
        .then(() => {
          this.loadBooks();
        });
  }
}

export default App;
