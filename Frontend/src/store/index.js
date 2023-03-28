import { createStore } from 'vuex'
import createPersistedState from "vuex-persistedstate";

export default createStore({
    plugins: [createPersistedState()],
    state: {
        form: {
            formName: "",
            email: "",
        },
        username: "Guest",
        token: ""
    },
    persist: {
        storage: sessionStorage
    },
    mutations: {
        UPDATE_FORM_NAME (state, formName) {
            state.form.formName = formName
            console.log("heii")
        },
        UPDATE_EMAIL (state, email) {
            state.form.email = email
            console.log("hallo")
        },
        UPDATE_USERNAME (state, username) {
            state.username = username
        },
        UPDATE_TOKEN(state, token) {
            state.token = token
        }
    },
    actions: {

    },
    modules: {

    }
})