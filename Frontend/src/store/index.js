import { createStore } from 'vuex'

export default createStore({
    state: {
        form: {
            formName: "",
            email: "",
        },
        username: "Guest"
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
        }
    },
    actions: {

    },
    modules: {

    }
})