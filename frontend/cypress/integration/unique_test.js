import { cyan } from "color-name"
import { AssertionError } from "assert"
import {get } from "http"

/*
Task #4
Write down a simple integration test to the task #3 you did before.
No need to check all the data retrieved by the button pushing. Just a Company name would be enough !
*/
describe('Test to be fulfilled by the candidate', () => {
    it('clicking "type" shows the right headings', () => {
        cy.visit('http://localhost:4200/')

        // cy.pause()

        cy.contains('Get Companies').click()
        cy.get('.name')
            .contains('Ford')

    })
})