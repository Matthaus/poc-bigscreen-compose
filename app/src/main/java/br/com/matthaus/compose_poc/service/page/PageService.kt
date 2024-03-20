package br.com.matthaus.compose_poc.service.page

import br.com.matthaus.compose_poc.model.Page

interface PageService {
    suspend fun getPageByType(type: PageType): Page
}