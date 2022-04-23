import axios from '../custom-axios/axios';

const ELibService = {
    fetchAuthors: () => {
        return axios.get("/authors");
    },
    fetchCountries: () => {
        return axios.get("/countries");
    },
    fetchBooks: () => {
        return axios.get("/books");
    },
    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`);
    },
    addBook: (name, author, availableCopies) => {
        return axios.post("/books/add", {
            "name" : name,
            "author" : author,
            "availableCopies" : availableCopies
        });
    },
    editBook: (id,name, author, availableCopies) => {
        return axios.put(`/books/edit/${id}`, {
            "name" : name,
            "author" : author,
            "availableCopies" : availableCopies
        });
    },
    getBook: (id) => {
        return axios.get(`/books/${id}`);
    }
}

export default ELibService;
