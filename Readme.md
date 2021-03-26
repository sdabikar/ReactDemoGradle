openapi: 3.0.1
info:
  title: Product Ordering
  description: "**TMF API Reference : TMF 622 - Product Ordering Management**\n\n\
    **Release : 19.0 - June 2019**\n\nThe Product Ordering API provides a standardized\
    \ mechanism for placing a product order with all of the necessary order parameters.\
    \ The API consists of a simple set of operations that interact with CRM/Order\
    \ Negotiation systems in a consistent manner. A product order is created based\
    \ on a product offer that is defined in a catalog. The product offer identifies\
    \ the product or set of products that are available to a customer, and includes\
    \ characteristics such as pricing, product options and market. This API provide\
    \ a task based resource to request order cancellation.\n\nThe product order references\
    \ the product offer and identifies any specific requests made by the customer.\n\
    \n**Product Order resource**\nA Product Order is a type of order which can be\
    \ used to place an order between a customer and a service provider or between\
    \ a service provider and a partner and vice versa. Main Product Order attributes\
    \ are its identifier, state, priority category (mass market, Enterprise, etc.)\
    \ related dates (start, completion, etc.), related billing account, related parties\
    \ and order items. Main Order Items (aka order lines) attributes are the ordered\
    \ offering and product characteristics with the related action to be performed\
    \ (e.g. add or delete the products), state, location information for delivery,\
    \ order item price and price alteration.\n\nProduct Order API performs the following\
    \ operations on product order :\n\n   -Retrieval of a product order or a collection\
    \ of product orders depending on filter criteria\n    -Partial update of a product\
    \ order (including updating rules)\n   -Creation of a product order (including\
    \ default values and creation rules)\n   -Deletion of product order (for administration\
    \ purposes)\n    -Notification of events on product order.\n\n**cancelProductOrder\
    \ resource**\nThis resource is used to request a product order cancellation.\n\
    Product Order API performs the following operations on product order :\n\n   -Retrieval\
    \ of a cancel product order or a collection of cancel product orders \n   -Creation\
    \ of a cancel product order \n   -Notification of events on cancel product order.\n\
    \n\nCopyright © TM Forum 2019. All Rights Reserved\n\n\n"
  version: 4.0.0
servers:
- url: https://serverRoot/tmf-api/productOrderingManagement/v4/
tags:
- name: productOrder
- name: cancelProductOrder
- name: notification listeners (client side)
- name: events subscription
paths:
  /productOrder:
    get:
      tags:
      - productOrder
      summary: List or find ProductOrder objects
      description: This operation list or find ProductOrder entities
      operationId: listProductOrder
      parameters:
      - name: fields
        in: query
        description: Comma-separated properties to be provided in response
        schema:
          type: string
      - name: offset
        in: query
        description: Requested index for start of resources to be provided in response
        schema:
          type: integer
      - name: limit
        in: query
        description: Requested number of resources to be provided in response
        schema:
          type: integer
      responses:
        200:
          description: Success
          headers:
            X-Total-Count:
              description: Total number of items matching criteria
              schema:
                type: integer
            X-Result-Count:
              description: Actual number of items returned in the response body
              schema:
                type: integer
          content:
            application/json;charset=utf-8:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/ProductOrder'
        400:
          description: Bad Request
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        401:
          description: Unauthorized
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        403:
          description: Forbidden
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        404:
          description: Not Found
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        405:
          description: Method Not allowed
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        409:
          description: Conflict
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        500:
          description: Internal Server Error
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
    post:
      tags:
      - productOrder
      summary: Creates a ProductOrder
      description: This operation creates a ProductOrder entity.
      operationId: createProductOrder
      requestBody:
        description: The ProductOrder to be created
        content:
          application/json;charset=utf-8:
            schema:
              $ref: '#/components/schemas/ProductOrder_Create'
        required: true
      responses:
        201:
          description: Created
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/ProductOrder'
        400:
          description: Bad Request
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        401:
          description: Unauthorized
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        403:
          description: Forbidden
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        405:
          description: Method Not allowed
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        409:
          description: Conflict
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        500:
          description: Internal Server Error
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
      x-codegen-request-body-name: productOrder
  /productOrder/{id}:
    get:
      tags:
      - productOrder
      summary: Retrieves a ProductOrder by ID
      description: This operation retrieves a ProductOrder entity. Attribute selection
        is enabled for all first level attributes.
      operationId: retrieveProductOrder
      parameters:
      - name: id
        in: path
        description: Identifier of the ProductOrder
        required: true
        schema:
          type: string
      - name: fields
        in: query
        description: Comma-separated properties to provide in response
        schema:
          type: string
      responses:
        200:
          description: Success
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/ProductOrder'
        400:
          description: Bad Request
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        401:
          description: Unauthorized
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        403:
          description: Forbidden
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        404:
          description: Not Found
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        405:
          description: Method Not allowed
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        409:
          description: Conflict
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        500:
          description: Internal Server Error
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
    delete:
      tags:
      - productOrder
      summary: Deletes a ProductOrder
      description: This operation deletes a ProductOrder entity.
      operationId: deleteProductOrder
      parameters:
      - name: id
        in: path
        description: Identifier of the ProductOrder
        required: true
        schema:
          type: string
      responses:
        204:
          description: Deleted
          content: {}
        400:
          description: Bad Request
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        401:
          description: Unauthorized
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        403:
          description: Forbidden
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        404:
          description: Not Found
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        405:
          description: Method Not allowed
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        409:
          description: Conflict
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        500:
          description: Internal Server Error
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
    patch:
      tags:
      - productOrder
      summary: Updates partially a ProductOrder
      description: This operation updates partially a ProductOrder entity.
      operationId: patchProductOrder
      parameters:
      - name: id
        in: path
        description: Identifier of the ProductOrder
        required: true
        schema:
          type: string
      requestBody:
        description: The ProductOrder to be updated
        content:
          application/json;charset=utf-8:
            schema:
              $ref: '#/components/schemas/ProductOrder_Update'
        required: true
      responses:
        200:
          description: Updated
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/ProductOrder'
        400:
          description: Bad Request
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        401:
          description: Unauthorized
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        403:
          description: Forbidden
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        404:
          description: Not Found
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        405:
          description: Method Not allowed
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        409:
          description: Conflict
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        500:
          description: Internal Server Error
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
      x-codegen-request-body-name: productOrder
  /cancelProductOrder:
    get:
      tags:
      - cancelProductOrder
      summary: List or find CancelProductOrder objects
      description: This operation list or find CancelProductOrder entities
      operationId: listCancelProductOrder
      parameters:
      - name: fields
        in: query
        description: Comma-separated properties to be provided in response
        schema:
          type: string
      - name: offset
        in: query
        description: Requested index for start of resources to be provided in response
        schema:
          type: integer
      - name: limit
        in: query
        description: Requested number of resources to be provided in response
        schema:
          type: integer
      responses:
        200:
          description: Success
          headers:
            X-Total-Count:
              description: Total number of items matching criteria
              schema:
                type: integer
            X-Result-Count:
              description: Actual number of items returned in the response body
              schema:
                type: integer
          content:
            application/json;charset=utf-8:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/CancelProductOrder'
        400:
          description: Bad Request
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        401:
          description: Unauthorized
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        403:
          description: Forbidden
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        404:
          description: Not Found
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        405:
          description: Method Not allowed
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        409:
          description: Conflict
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        500:
          description: Internal Server Error
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
    post:
      tags:
      - cancelProductOrder
      summary: Creates a CancelProductOrder
      description: This operation creates a CancelProductOrder entity.
      operationId: createCancelProductOrder
      requestBody:
        description: The CancelProductOrder to be created
        content:
          application/json;charset=utf-8:
            schema:
              $ref: '#/components/schemas/CancelProductOrder_Create'
        required: true
      responses:
        201:
          description: Created
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/CancelProductOrder'
        400:
          description: Bad Request
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        401:
          description: Unauthorized
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        403:
          description: Forbidden
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        405:
          description: Method Not allowed
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        409:
          description: Conflict
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        500:
          description: Internal Server Error
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
      x-codegen-request-body-name: cancelProductOrder
  /cancelProductOrder/{id}:
    get:
      tags:
      - cancelProductOrder
      summary: Retrieves a CancelProductOrder by ID
      description: This operation retrieves a CancelProductOrder entity. Attribute
        selection is enabled for all first level attributes.
      operationId: retrieveCancelProductOrder
      parameters:
      - name: id
        in: path
        description: Identifier of the CancelProductOrder
        required: true
        schema:
          type: string
      - name: fields
        in: query
        description: Comma-separated properties to provide in response
        schema:
          type: string
      responses:
        200:
          description: Success
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/CancelProductOrder'
        400:
          description: Bad Request
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        401:
          description: Unauthorized
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        403:
          description: Forbidden
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        404:
          description: Not Found
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        405:
          description: Method Not allowed
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        409:
          description: Conflict
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        500:
          description: Internal Server Error
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
  /hub:
    post:
      tags:
      - events subscription
      summary: Register a listener
      description: Sets the communication endpoint address the service instance must
        use to deliver information about its health state, execution state, failures
        and metrics.
      operationId: registerListener
      requestBody:
        description: Data containing the callback endpoint to deliver the information
        content:
          application/json;charset=utf-8:
            schema:
              $ref: '#/components/schemas/EventSubscriptionInput'
        required: true
      responses:
        201:
          description: Subscribed
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/EventSubscription'
        400:
          description: Bad Request
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        401:
          description: Unauthorized
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        403:
          description: Forbidden
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        404:
          description: Not Found
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        405:
          description: Method Not allowed
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        409:
          description: Conflict
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        500:
          description: Internal Server Error
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
      x-codegen-request-body-name: data
  /hub/{id}:
    delete:
      tags:
      - events subscription
      summary: Unregister a listener
      description: Resets the communication endpoint address the service instance
        must use to deliver information about its health state, execution state, failures
        and metrics.
      operationId: unregisterListener
      parameters:
      - name: id
        in: path
        description: The id of the registered listener
        required: true
        schema:
          type: string
      responses:
        204:
          description: Deleted
          content: {}
        400:
          description: Bad request
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        401:
          description: Unauthorized
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        403:
          description: Forbidden
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        404:
          description: Not Found
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        405:
          description: Method not allowed
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        500:
          description: Internal Server Error
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
  /listener/productOrderCreateEvent:
    post:
      tags:
      - notification listeners (client side)
      summary: Client listener for entity ProductOrderCreateEvent
      description: Example of a client listener for receiving the notification ProductOrderCreateEvent
      operationId: listenToProductOrderCreateEvent
      requestBody:
        description: The event data
        content:
          application/json;charset=utf-8:
            schema:
              $ref: '#/components/schemas/ProductOrderCreateEvent'
        required: true
      responses:
        201:
          description: Notified
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/EventSubscription'
        400:
          description: Bad Request
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        401:
          description: Unauthorized
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        403:
          description: Forbidden
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        404:
          description: Not Found
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        405:
          description: Method Not allowed
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        409:
          description: Conflict
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        500:
          description: Internal Server Error
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
      x-codegen-request-body-name: data
  /listener/productOrderAttributeValueChangeEvent:
    post:
      tags:
      - notification listeners (client side)
      summary: Client listener for entity ProductOrderAttributeValueChangeEvent
      description: Example of a client listener for receiving the notification ProductOrderAttributeValueChangeEvent
      operationId: listenToProductOrderAttributeValueChangeEvent
      requestBody:
        description: The event data
        content:
          application/json;charset=utf-8:
            schema:
              $ref: '#/components/schemas/ProductOrderAttributeValueChangeEvent'
        required: true
      responses:
        201:
          description: Notified
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/EventSubscription'
        400:
          description: Bad Request
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        401:
          description: Unauthorized
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        403:
          description: Forbidden
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        404:
          description: Not Found
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        405:
          description: Method Not allowed
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        409:
          description: Conflict
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        500:
          description: Internal Server Error
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
      x-codegen-request-body-name: data
  /listener/productOrderDeleteEvent:
    post:
      tags:
      - notification listeners (client side)
      summary: Client listener for entity ProductOrderDeleteEvent
      description: Example of a client listener for receiving the notification ProductOrderDeleteEvent
      operationId: listenToProductOrderDeleteEvent
      requestBody:
        description: The event data
        content:
          application/json;charset=utf-8:
            schema:
              $ref: '#/components/schemas/ProductOrderDeleteEvent'
        required: true
      responses:
        201:
          description: Notified
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/EventSubscription'
        400:
          description: Bad Request
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        401:
          description: Unauthorized
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        403:
          description: Forbidden
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        404:
          description: Not Found
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        405:
          description: Method Not allowed
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        409:
          description: Conflict
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        500:
          description: Internal Server Error
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
      x-codegen-request-body-name: data
  /listener/productOrderStateChangeEvent:
    post:
      tags:
      - notification listeners (client side)
      summary: Client listener for entity ProductOrderStateChangeEvent
      description: Example of a client listener for receiving the notification ProductOrderStateChangeEvent
      operationId: listenToProductOrderStateChangeEvent
      requestBody:
        description: The event data
        content:
          application/json;charset=utf-8:
            schema:
              $ref: '#/components/schemas/ProductOrderStateChangeEvent'
        required: true
      responses:
        201:
          description: Notified
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/EventSubscription'
        400:
          description: Bad Request
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        401:
          description: Unauthorized
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        403:
          description: Forbidden
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        404:
          description: Not Found
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        405:
          description: Method Not allowed
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        409:
          description: Conflict
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        500:
          description: Internal Server Error
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
      x-codegen-request-body-name: data
  /listener/productOrderInformationRequiredEvent:
    post:
      tags:
      - notification listeners (client side)
      summary: Client listener for entity ProductOrderInformationRequiredEvent
      description: Example of a client listener for receiving the notification ProductOrderInformationRequiredEvent
      operationId: listenToProductOrderInformationRequiredEvent
      requestBody:
        description: The event data
        content:
          application/json;charset=utf-8:
            schema:
              $ref: '#/components/schemas/ProductOrderInformationRequiredEvent'
        required: true
      responses:
        201:
          description: Notified
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/EventSubscription'
        400:
          description: Bad Request
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        401:
          description: Unauthorized
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        403:
          description: Forbidden
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        404:
          description: Not Found
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        405:
          description: Method Not allowed
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        409:
          description: Conflict
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        500:
          description: Internal Server Error
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
      x-codegen-request-body-name: data
  /listener/cancelProductOrderCreateEvent:
    post:
      tags:
      - notification listeners (client side)
      summary: Client listener for entity CancelProductOrderCreateEvent
      description: Example of a client listener for receiving the notification CancelProductOrderCreateEvent
      operationId: listenToCancelProductOrderCreateEvent
      requestBody:
        description: The event data
        content:
          application/json;charset=utf-8:
            schema:
              $ref: '#/components/schemas/CancelProductOrderCreateEvent'
        required: true
      responses:
        201:
          description: Notified
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/EventSubscription'
        400:
          description: Bad Request
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        401:
          description: Unauthorized
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        403:
          description: Forbidden
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        404:
          description: Not Found
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        405:
          description: Method Not allowed
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        409:
          description: Conflict
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        500:
          description: Internal Server Error
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
      x-codegen-request-body-name: data
  /listener/cancelProductOrderStateChangeEvent:
    post:
      tags:
      - notification listeners (client side)
      summary: Client listener for entity CancelProductOrderStateChangeEvent
      description: Example of a client listener for receiving the notification CancelProductOrderStateChangeEvent
      operationId: listenToCancelProductOrderStateChangeEvent
      requestBody:
        description: The event data
        content:
          application/json;charset=utf-8:
            schema:
              $ref: '#/components/schemas/CancelProductOrderStateChangeEvent'
        required: true
      responses:
        201:
          description: Notified
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/EventSubscription'
        400:
          description: Bad Request
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        401:
          description: Unauthorized
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        403:
          description: Forbidden
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        404:
          description: Not Found
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        405:
          description: Method Not allowed
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        409:
          description: Conflict
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        500:
          description: Internal Server Error
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
      x-codegen-request-body-name: data
  /listener/cancelProductOrderInformationRequiredEvent:
    post:
      tags:
      - notification listeners (client side)
      summary: Client listener for entity CancelProductOrderInformationRequiredEvent
      description: Example of a client listener for receiving the notification CancelProductOrderInformationRequiredEvent
      operationId: listenToCancelProductOrderInformationRequiredEvent
      requestBody:
        description: The event data
        content:
          application/json;charset=utf-8:
            schema:
              $ref: '#/components/schemas/CancelProductOrderInformationRequiredEvent'
        required: true
      responses:
        201:
          description: Notified
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/EventSubscription'
        400:
          description: Bad Request
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        401:
          description: Unauthorized
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        403:
          description: Forbidden
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        404:
          description: Not Found
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        405:
          description: Method Not allowed
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        409:
          description: Conflict
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
        500:
          description: Internal Server Error
          content:
            application/json;charset=utf-8:
              schema:
                $ref: '#/components/schemas/Error'
      x-codegen-request-body-name: data
components:
  schemas:
    AgreementItemRef:
      required:
      - id
      type: object
      properties:
        id:
          type: string
          description: Unique identifier of a related entity.
        href:
          type: string
          description: Reference of the related entity.
        agreementItemId:
          type: string
          description: Identifier of the agreement
        name:
          type: string
          description: Name of the related entity.
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
        '@referredType':
          type: string
          description: The actual type of the target instance when needed for disambiguation.
      description: Agreement reference. An agreement represents a contract or arrangement,
        either written or verbal and sometimes enforceable by law, such as a service
        level agreement or a customer price agreement. An agreement involves a number
        of other business entities, such as products, services, and resources and/or
        their specifications.
    AgreementRef:
      required:
      - id
      type: object
      properties:
        id:
          type: string
          description: Unique identifier of a related entity.
        href:
          type: string
          description: Reference of the related entity.
        name:
          type: string
          description: Name of the agreement
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
        '@referredType':
          type: string
          description: The actual type of the target instance when needed for disambiguation.
      description: Agreement reference. An agreement represents a contract or arrangement,
        either written or verbal and sometimes enforceable by law, such as a service
        level agreement or a customer price agreement. An agreement involves a number
        of other business entities, such as products, services, and resources and/or
        their specifications.
    Any:
      type: object
    AppointmentRef:
      required:
      - id
      type: object
      properties:
        id:
          type: string
          description: The identifier of the referred appointment
        href:
          type: string
          description: The reference of the appointment
        description:
          type: string
          description: An explanatory text regarding the appointment made with a party
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
        '@referredType':
          type: string
          description: The actual type of the target instance when needed for disambiguation
      description: Refers an appointment, such as a Customer presentation or internal
        meeting or site visit
    BillingAccountRef:
      required:
      - id
      type: object
      properties:
        id:
          type: string
          description: Unique identifier of the billing account
        href:
          type: string
          description: Reference of the billing account
        name:
          type: string
          description: Name of the billing account
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
        '@referredType':
          type: string
          description: The actual type of the target instance when needed for disambiguation.
      description: BillingAccount reference. A BillingAccount is a detailed description
        of a bill structure.
    CancelOrder:
      type: object
      properties:
        id:
          type: string
          description: id of the cancellation request (this is not an order id)
        href:
          type: string
          description: Hyperlink to access the cancellation request
        cancellationReason:
          type: string
          description: Reason why the order is cancelled.
        effectiveCancellationDate:
          type: string
          description: Date when the order is cancelled.
          format: date-time
        requestedCancellationDate:
          type: string
          description: Date when the submitter wants the order to be cancelled
          format: date-time
        state:
          $ref: '#/components/schemas/TaskStateType'
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
      description: A Order cancel is a type of task which  can  be used to place a
        request to cancel an order
    CancelProductOrder:
      required:
      - productOrder
      type: object
      properties:
        id:
          type: string
          description: id of the cancellation request (this is not an order id)
        href:
          type: string
          description: Hyperlink to access the cancellation request
        cancellationReason:
          type: string
          description: Reason why the order is cancelled.
        effectiveCancellationDate:
          type: string
          description: Date when the order is cancelled.
          format: date-time
        requestedCancellationDate:
          type: string
          description: Date when the submitter wants the order to be cancelled
          format: date-time
        productOrder:
          $ref: '#/components/schemas/ProductOrderRef'
        state:
          $ref: '#/components/schemas/TaskStateType'
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
      description: Request for cancellation an existing product order
    CancelProductOrder_Create:
      required:
      - productOrder
      type: object
      properties:
        cancellationReason:
          type: string
          description: Reason why the order is cancelled.
        requestedCancellationDate:
          type: string
          description: Date when the submitter wants the order to be cancelled
          format: date-time
        productOrder:
          $ref: '#/components/schemas/ProductOrderRef'
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
      description: |-
        Request for cancellation an existing product order
        Skipped properties: id,href,state,effectiveCancellationDate
    Characteristic:
      required:
      - name
      - value
      type: object
      properties:
        name:
          type: string
          description: Name of the characteristic
        valueType:
          type: string
          description: Data type of the value of the characteristic
        value:
          $ref: '#/components/schemas/Any'
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
      description: Describes a given characteristic of an object or entity through
        a name/value pair.
    EntityRef:
      required:
      - id
      type: object
      properties:
        id:
          type: string
          description: Unique identifier of a related entity.
        href:
          type: string
          description: Reference of the related entity.
        name:
          type: string
          description: Name of the related entity.
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
        '@referredType':
          type: string
          description: The actual type of the target instance when needed for disambiguation.
      description: Entity reference schema to be use for all entityRef class.
    Money:
      type: object
      properties:
        unit:
          type: string
          description: Currency (ISO4217 norm uses 3 letters to define the currency)
        value:
          type: number
          description: A positive floating point number
          format: float
      description: A base / value business entity used to represent money
    Note:
      required:
      - text
      type: object
      properties:
        id:
          type: string
          description: Identifier of the note within its containing entity (may or
            may not be globally unique, depending on provider implementation)
        author:
          type: string
          description: Author of the note
        date:
          type: string
          description: Date of the note
          format: date-time
        text:
          type: string
          description: Text of the note
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
      description: Extra information about a given entity
    OrderItemActionType:
      type: string
      description: action to be performed on the product
      enum:
      - add
      - modify
      - delete
      - noChange
    OrderItemRelationship:
      type: object
      properties:
        id:
          type: string
        relationshipType:
          type: string
          description: The type of order item relationship
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
    OrderPrice:
      type: object
      properties:
        description:
          type: string
          description: A narrative that explains in detail the semantics of this order
            item price.
        name:
          type: string
          description: A short descriptive name such as "Subscription price".
        priceType:
          type: string
          description: A category that describes the price, such as recurring, discount,
            allowance, penalty, and so forth
        recurringChargePeriod:
          type: string
          description: Could be month, week...
        unitOfMeasure:
          type: string
          description: Could be minutes, GB...
        billingAccount:
          $ref: '#/components/schemas/BillingAccountRef'
        price:
          $ref: '#/components/schemas/Price'
        priceAlteration:
          type: array
          description: a strucuture used to describe a price alteration
          items:
            $ref: '#/components/schemas/PriceAlteration'
        productOfferingPrice:
          $ref: '#/components/schemas/ProductOfferingPriceRef'
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
      description: An amount, usually of money, that represents the actual price paid
        by the Customer for this item or this order
    OrderTerm:
      type: object
      properties:
        description:
          type: string
          description: Description of the productOrderTerm
        name:
          type: string
          description: Name of the productOrderTerm
        duration:
          $ref: '#/components/schemas/Quantity'
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
      description: Description of a productTerm linked to this orderItem. This represent
        a commitment with a duration
    PaymentRef:
      required:
      - id
      type: object
      properties:
        id:
          type: string
          description: Unique identifier of a related entity.
        href:
          type: string
          description: Reference of the related entity.
        name:
          type: string
          description: A name for the payment
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
        '@referredType':
          type: string
          description: The actual type of the target instance when needed for disambiguation.
      description: If an immediate payment has been done at the product order submission,
        the payment information are captured and stored (as a reference) in the order.
    Place:
      type: object
      properties:
        id:
          type: string
          description: Unique identifier of the place
        href:
          type: string
          description: Unique reference of the place
        name:
          type: string
          description: A user-friendly name for the place, such as [Paris Store],
            [London Store], [Main Home]
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
      description: Place reference. Place defines the places where the products are
        sold or delivered.
    PlaceRef:
      required:
      - id
      type: object
      properties:
        id:
          type: string
          description: Unique identifier of a related entity.
        href:
          type: string
          description: Reference of the related entity.
        name:
          type: string
          description: Name of the related entity.
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
        '@referredType':
          type: string
          description: The actual type of the target instance when needed for disambiguation.
      description: Place reference. PlaceRef defines the placeRefs where the products
        are sold or delivered.
    Price:
      type: object
      properties:
        percentage:
          type: number
          description: Percentage to apply for ProdOfferPriceAlteration
          format: float
        taxRate:
          type: number
          description: Tax rate
          format: float
        dutyFreeAmount:
          $ref: '#/components/schemas/Money'
        taxIncludedAmount:
          $ref: '#/components/schemas/Money'
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
      description: Provides all amounts (tax included, duty free, tax rate), used
        currency and percentage to apply for Price Alteration.
    PriceAlteration:
      required:
      - price
      - priceType
      type: object
      properties:
        applicationDuration:
          type: integer
          description: Duration during which the alteration applies on the order item
            price (for instance 2 months free of charge for the recurring charge)
        description:
          type: string
          description: A narrative that explains in detail the semantics of this order
            item price alteration
        name:
          type: string
          description: Name of the order item price alteration
        priceType:
          type: string
          description: A category that describes the price such as recurring, one
            time and usage.
        priority:
          type: integer
          description: Priority level for applying this alteration among all the defined
            alterations on the order item price
        recurringChargePeriod:
          type: string
          description: Could be month, week...
        unitOfMeasure:
          type: string
          description: Could be minutes, GB...
        price:
          $ref: '#/components/schemas/Price'
        productOfferingPrice:
          $ref: '#/components/schemas/ProductOfferingPriceRef'
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
      description: Is an amount, usually of money, that modifies the price charged
        for an order item.
    Product:
      type: object
      properties:
        id:
          type: string
          description: Unique identifier of the product
        href:
          type: string
          description: Reference of the product
        description:
          type: string
          description: Is the description of the product. It could be copied from
            the description of the Product Offering.
        isBundle:
          type: boolean
          description: If true, the product is a ProductBundle which is an instantiation
            of a BundledProductOffering. If false, the product is a ProductComponent
            which is an instantiation of a SimpleProductOffering.
        isCustomerVisible:
          type: boolean
          description: If true, the product is visible by the customer.
        name:
          type: string
          description: Name of the product. It could be the same as the name of the
            product offering
        orderDate:
          type: string
          description: Is the date when the product was ordered
          format: date-time
        productSerialNumber:
          type: string
          description: Is the serial number for the product. This is typically applicable
            to tangible products e.g. Broadband Router.
        startDate:
          type: string
          description: Is the date from which the product starts
          format: date-time
        terminationDate:
          type: string
          description: Is the date when the product was terminated
          format: date-time
        agreement:
          type: array
          items:
            $ref: '#/components/schemas/AgreementItemRef'
        billingAccount:
          $ref: '#/components/schemas/BillingAccountRef'
        place:
          type: array
          items:
            $ref: '#/components/schemas/RelatedPlaceRefOrValue'
        product:
          type: array
          items:
            $ref: '#/components/schemas/ProductRefOrValue'
        productCharacteristic:
          type: array
          items:
            $ref: '#/components/schemas/Characteristic'
        productOffering:
          $ref: '#/components/schemas/ProductOfferingRef'
        productOrderItem:
          type: array
          items:
            $ref: '#/components/schemas/RelatedProductOrderItem'
        productPrice:
          type: array
          items:
            $ref: '#/components/schemas/ProductPrice'
        productRelationship:
          type: array
          items:
            $ref: '#/components/schemas/ProductRelationship'
        productSpecification:
          $ref: '#/components/schemas/ProductSpecificationRef'
        productTerm:
          type: array
          items:
            $ref: '#/components/schemas/ProductTerm'
        realizingResource:
          type: array
          items:
            $ref: '#/components/schemas/ResourceRef'
        realizingService:
          type: array
          items:
            $ref: '#/components/schemas/ServiceRef'
        relatedParty:
          type: array
          items:
            $ref: '#/components/schemas/RelatedParty'
        status:
          $ref: '#/components/schemas/ProductStatusType'
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
      description: A product offering procured by a customer or other interested party
        playing a party role. A product is realized as one or more service(s) and
        / or resource(s).
    ProductOfferingPriceRef:
      required:
      - id
      type: object
      properties:
        id:
          type: string
          description: Unique identifier of a related entity.
        href:
          type: string
          description: Reference of the related entity.
        name:
          type: string
          description: Name of the related entity.
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
        '@referredType':
          type: string
          description: The actual type of the target instance when needed for disambiguation.
      description: ProductPriceOffering reference. An amount, usually of money, that
        is asked for or allowed when a ProductOffering is bought, rented, or leased
    ProductOfferingQualificationItemRef:
      required:
      - id
      - productOfferingQualificationId
      type: object
      properties:
        id:
          type: string
          description: Id of an item of a product offering qualification
        href:
          type: string
          description: Reference of the related entity.
        name:
          type: string
          description: Name of the related entity.
        productOfferingQualificationHref:
          type: string
          description: Reference of the related entity.
        productOfferingQualificationId:
          type: string
          description: Unique identifier of a related entity.
        productOfferingQualificationName:
          type: string
          description: Name of the related entity.
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
        '@referredType':
          type: string
          description: The actual type of the target instance when needed for disambiguation.
      description: It's a productOfferingQualification item that has been executed
        previously.
    ProductOfferingQualificationRef:
      required:
      - id
      type: object
      properties:
        id:
          type: string
          description: Unique identifier of a related entity.
        href:
          type: string
          description: Reference of the related entity.
        name:
          type: string
          description: Name of the related entity.
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
        '@referredType':
          type: string
          description: The actual type of the target instance when needed for disambiguation.
      description: It's a productOfferingQualification that has been executed previously
    ProductOfferingRef:
      required:
      - id
      type: object
      properties:
        id:
          type: string
          description: Unique identifier of a related entity.
        href:
          type: string
          description: Reference of the related entity.
        name:
          type: string
          description: Name of the related entity.
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
        '@referredType':
          type: string
          description: The actual type of the target instance when needed for disambiguation.
      description: ProductOffering reference. A product offering represents entities
        that are orderable from the provider of the catalog, this resource includes
        pricing information.
    ProductOrder:
      required:
      - productOrderItem
      type: object
      properties:
        id:
          type: string
          description: ID created on repository side (OM system)
        href:
          type: string
          description: Hyperlink to access the order
        cancellationDate:
          type: string
          description: 'Date when the order is cancelled. This is used when order
            is cancelled. '
          format: date-time
        cancellationReason:
          type: string
          description: 'Reason why the order is cancelled. This is used when order
            is cancelled. '
        category:
          type: string
          description: Used to categorize the order from a business perspective that
            can be useful for the OM system (e.g. "enterprise", "residential", ...)
        completionDate:
          type: string
          description: Date when the order was completed
          format: date-time
        description:
          type: string
          description: Description of the product order
        expectedCompletionDate:
          type: string
          description: Expected delivery date amended by the provider
          format: date-time
        externalId:
          type: string
          description: ID given by the consumer and only understandable by him (to
            facilitate his searches afterwards)
        notificationContact:
          type: string
          description: Contact attached to the order to send back information regarding
            this order
        orderDate:
          type: string
          description: Date when the order was created
          format: date-time
        priority:
          type: string
          description: 'A way that can be used by consumers to prioritize orders in
            OM system (from 0 to 4 : 0 is the highest priority, and 4 the lowest)'
        requestedCompletionDate:
          type: string
          description: Requested delivery date from the requestor perspective
          format: date-time
        requestedStartDate:
          type: string
          description: 'Order fulfillment start date wished by the requestor. This
            is used when, for any reason, requestor cannot allow seller to begin to
            operationally begin the fulfillment before a date. '
          format: date-time
        agreement:
          type: array
          description: A reference to an agreement defined in the context of the product
            order
          items:
            $ref: '#/components/schemas/AgreementRef'
        billingAccount:
          $ref: '#/components/schemas/BillingAccountRef'
        channel:
          type: array
          items:
            $ref: '#/components/schemas/RelatedChannel'
        note:
          type: array
          items:
            $ref: '#/components/schemas/Note'
        orderTotalPrice:
          type: array
          items:
            $ref: '#/components/schemas/OrderPrice'
        payment:
          type: array
          items:
            $ref: '#/components/schemas/PaymentRef'
        productOfferingQualification:
          type: array
          items:
            $ref: '#/components/schemas/ProductOfferingQualificationRef'
        productOrderItem:
          minItems: 1
          type: array
          items:
            $ref: '#/components/schemas/ProductOrderItem'
        quote:
          type: array
          items:
            $ref: '#/components/schemas/QuoteRef'
        relatedParty:
          type: array
          items:
            $ref: '#/components/schemas/RelatedParty'
        state:
          $ref: '#/components/schemas/ProductOrderStateType'
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
      description: A Product Order is a type of order which  can  be used to place
        an order between a customer and a service provider or between a service provider
        and a partner and vice versa,
    ProductOrder_Create:
      required:
      - productOrderItem
      type: object
      properties:
        cancellationDate:
          type: string
          description: 'Date when the order is cancelled. This is used when order
            is cancelled. '
          format: date-time
        cancellationReason:
          type: string
          description: 'Reason why the order is cancelled. This is used when order
            is cancelled. '
        category:
          type: string
          description: Used to categorize the order from a business perspective that
            can be useful for the OM system (e.g. "enterprise", "residential", ...)
        description:
          type: string
          description: Description of the product order
        externalId:
          type: string
          description: ID given by the consumer and only understandable by him (to
            facilitate his searches afterwards)
        notificationContact:
          type: string
          description: Contact attached to the order to send back information regarding
            this order
        priority:
          type: string
          description: 'A way that can be used by consumers to prioritize orders in
            OM system (from 0 to 4 : 0 is the highest priority, and 4 the lowest)'
        requestedCompletionDate:
          type: string
          description: Requested delivery date from the requestor perspective
          format: date-time
        requestedStartDate:
          type: string
          description: 'Order fulfillment start date wished by the requestor. This
            is used when, for any reason, requestor cannot allow seller to begin to
            operationally begin the fulfillment before a date. '
          format: date-time
        agreement:
          type: array
          description: A reference to an agreement defined in the context of the product
            order
          items:
            $ref: '#/components/schemas/AgreementRef'
        billingAccount:
          $ref: '#/components/schemas/BillingAccountRef'
        channel:
          type: array
          items:
            $ref: '#/components/schemas/RelatedChannel'
        note:
          type: array
          items:
            $ref: '#/components/schemas/Note'
        orderTotalPrice:
          type: array
          items:
            $ref: '#/components/schemas/OrderPrice'
        payment:
          type: array
          items:
            $ref: '#/components/schemas/PaymentRef'
        productOfferingQualification:
          type: array
          items:
            $ref: '#/components/schemas/ProductOfferingQualificationRef'
        productOrderItem:
          minItems: 1
          type: array
          items:
            $ref: '#/components/schemas/ProductOrderItem'
        quote:
          type: array
          items:
            $ref: '#/components/schemas/QuoteRef'
        relatedParty:
          type: array
          items:
            $ref: '#/components/schemas/RelatedParty'
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
      description: |-
        A Product Order is a type of order which  can  be used to place an order between a customer and a service provider or between a service provider and a partner and vice versa,
        Skipped properties: id,href,completionDate,orderDate,state,expectedCompletionDate,productOrderItem.state
    ProductOrder_Update:
      required:
      - productOrderItem
      type: object
      properties:
        cancellationDate:
          type: string
          description: 'Date when the order is cancelled. This is used when order
            is cancelled. '
          format: date-time
        cancellationReason:
          type: string
          description: 'Reason why the order is cancelled. This is used when order
            is cancelled. '
        category:
          type: string
          description: Used to categorize the order from a business perspective that
            can be useful for the OM system (e.g. "enterprise", "residential", ...)
        completionDate:
          type: string
          description: Date when the order was completed
          format: date-time
        description:
          type: string
          description: Description of the product order
        expectedCompletionDate:
          type: string
          description: Expected delivery date amended by the provider
          format: date-time
        externalId:
          type: string
          description: ID given by the consumer and only understandable by him (to
            facilitate his searches afterwards)
        notificationContact:
          type: string
          description: Contact attached to the order to send back information regarding
            this order
        priority:
          type: string
          description: 'A way that can be used by consumers to prioritize orders in
            OM system (from 0 to 4 : 0 is the highest priority, and 4 the lowest)'
        requestedCompletionDate:
          type: string
          description: Requested delivery date from the requestor perspective
          format: date-time
        requestedStartDate:
          type: string
          description: 'Order fulfillment start date wished by the requestor. This
            is used when, for any reason, requestor cannot allow seller to begin to
            operationally begin the fulfillment before a date. '
          format: date-time
        agreement:
          type: array
          description: A reference to an agreement defined in the context of the product
            order
          items:
            $ref: '#/components/schemas/AgreementRef'
        billingAccount:
          $ref: '#/components/schemas/BillingAccountRef'
        channel:
          type: array
          items:
            $ref: '#/components/schemas/RelatedChannel'
        note:
          type: array
          items:
            $ref: '#/components/schemas/Note'
        orderTotalPrice:
          type: array
          items:
            $ref: '#/components/schemas/OrderPrice'
        payment:
          type: array
          items:
            $ref: '#/components/schemas/PaymentRef'
        productOfferingQualification:
          type: array
          items:
            $ref: '#/components/schemas/ProductOfferingQualificationRef'
        productOrderItem:
          minItems: 1
          type: array
          items:
            $ref: '#/components/schemas/ProductOrderItem'
        quote:
          type: array
          items:
            $ref: '#/components/schemas/QuoteRef'
        relatedParty:
          type: array
          items:
            $ref: '#/components/schemas/RelatedParty'
        state:
          $ref: '#/components/schemas/ProductOrderStateType'
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
      description: |-
        A Product Order is a type of order which  can  be used to place an order between a customer and a service provider or between a service provider and a partner and vice versa,
        Skipped properties: id,href,orderDate
    ProductOrderItem:
      required:
      - action
      - id
      type: object
      properties:
        id:
          type: string
          description: Identifier of the line item (generally it is a sequence number
            01, 02, 03, ...)
        quantity:
          type: integer
          description: Quantity ordered
        action:
          $ref: '#/components/schemas/OrderItemActionType'
        appointment:
          $ref: '#/components/schemas/AppointmentRef'
        billingAccount:
          $ref: '#/components/schemas/BillingAccountRef'
        itemPrice:
          type: array
          items:
            $ref: '#/components/schemas/OrderPrice'
        itemTerm:
          type: array
          items:
            $ref: '#/components/schemas/OrderTerm'
        itemTotalPrice:
          type: array
          items:
            $ref: '#/components/schemas/OrderPrice'
        payment:
          type: array
          items:
            $ref: '#/components/schemas/PaymentRef'
        product:
          $ref: '#/components/schemas/ProductRefOrValue'
        productOffering:
          $ref: '#/components/schemas/ProductOfferingRef'
        productOfferingQualificationItem:
          $ref: '#/components/schemas/ProductOfferingQualificationItemRef'
        productOrderItem:
          type: array
          items:
            $ref: '#/components/schemas/ProductOrderItem'
        productOrderItemRelationship:
          type: array
          items:
            $ref: '#/components/schemas/OrderItemRelationship'
        qualification:
          type: array
          items:
            $ref: '#/components/schemas/ProductOfferingQualificationRef'
        quoteItem:
          $ref: '#/components/schemas/QuoteItemRef'
        state:
          $ref: '#/components/schemas/ProductOrderItemStateType'
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
      description: An identified part of the order. A product order is decomposed
        into one or more order items.
    ProductOrderItemStateType:
      type: string
      description: Possible values for the state of the product order item
      enum:
      - acknowledged
      - rejected
      - pending
      - held
      - inProgress
      - cancelled
      - completed
      - failed
      - assessingCancellation
      - pendingCancellation
    ProductOrderRef:
      required:
      - id
      type: object
      properties:
        id:
          type: string
          description: Unique identifier of a related entity.
        href:
          type: string
          description: Reference of the related entity.
        name:
          type: string
          description: Name of the related entity.
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
        '@referredType':
          type: string
          description: The actual type of the target instance when needed for disambiguation.
      description: ProductOrder (ProductOrder) .The product order which the recommendation
        is related with.
    ProductOrderStateType:
      type: string
      description: Possible values for the state of the order
      enum:
      - acknowledged
      - rejected
      - pending
      - held
      - inProgress
      - cancelled
      - completed
      - failed
      - partial
      - assessingCancellation
      - pendingCancellation
    ProductPrice:
      required:
      - price
      - priceType
      type: object
      properties:
        description:
          type: string
          description: A narrative that explains in detail the semantics of this product
            price.
        name:
          type: string
          description: A short descriptive name such as "Subscription price".
        priceType:
          type: string
          description: A category that describes the price, such as recurring, discount,
            allowance, penalty, and so forth.
        recurringChargePeriod:
          type: string
          description: Could be month, week...
        unitOfMeasure:
          type: string
          description: Could be minutes, GB...
        billingAccount:
          $ref: '#/components/schemas/BillingAccountRef'
        price:
          $ref: '#/components/schemas/Price'
        productOfferingPrice:
          $ref: '#/components/schemas/ProductOfferingPriceRef'
        productPriceAlteration:
          type: array
          items:
            $ref: '#/components/schemas/PriceAlteration'
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
      description: An amount, usually of money, that represents the actual price paid
        by a Customer for a purchase, a rent or a lease of a Product. The price is
        valid for a defined period of time.
    ProductRef:
      required:
      - id
      type: object
      properties:
        id:
          type: string
          description: Unique identifier of a related entity.
        href:
          type: string
          description: Reference of the related entity.
        name:
          type: string
          description: Name of the related entity.
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
        '@referredType':
          type: string
          description: The actual type of the target instance when needed for disambiguation.
    ProductRefOrValue:
      type: object
      properties:
        id:
          type: string
          description: Unique identifier of the product
        href:
          type: string
          description: Reference of the product
        description:
          type: string
          description: Is the description of the product. It could be copied from
            the description of the Product Offering.
        isBundle:
          type: boolean
          description: If true, the product is a ProductBundle which is an instantiation
            of a BundledProductOffering. If false, the product is a ProductComponent
            which is an instantiation of a SimpleProductOffering.
        isCustomerVisible:
          type: boolean
          description: If true, the product is visible by the customer.
        name:
          type: string
          description: Name of the product. It could be the same as the name of the
            product offering
        orderDate:
          type: string
          description: Is the date when the product was ordered
          format: date-time
        productSerialNumber:
          type: string
          description: Is the serial number for the product. This is typically applicable
            to tangible products e.g. Broadband Router.
        startDate:
          type: string
          description: Is the date from which the product starts
          format: date-time
        terminationDate:
          type: string
          description: Is the date when the product was terminated
          format: date-time
        agreement:
          type: array
          items:
            $ref: '#/components/schemas/AgreementItemRef'
        billingAccount:
          $ref: '#/components/schemas/BillingAccountRef'
        place:
          type: array
          items:
            $ref: '#/components/schemas/RelatedPlaceRefOrValue'
        product:
          type: array
          items:
            $ref: '#/components/schemas/ProductRefOrValue'
        productCharacteristic:
          type: array
          items:
            $ref: '#/components/schemas/Characteristic'
        productOffering:
          $ref: '#/components/schemas/ProductOfferingRef'
        productOrderItem:
          type: array
          items:
            $ref: '#/components/schemas/RelatedProductOrderItem'
        productPrice:
          type: array
          items:
            $ref: '#/components/schemas/ProductPrice'
        productRelationship:
          type: array
          items:
            $ref: '#/components/schemas/ProductRelationship'
        productSpecification:
          $ref: '#/components/schemas/ProductSpecificationRef'
        productTerm:
          type: array
          items:
            $ref: '#/components/schemas/ProductTerm'
        realizingResource:
          type: array
          items:
            $ref: '#/components/schemas/ResourceRef'
        realizingService:
          type: array
          items:
            $ref: '#/components/schemas/ServiceRef'
        relatedParty:
          type: array
          items:
            $ref: '#/components/schemas/RelatedParty'
        status:
          $ref: '#/components/schemas/ProductStatusType'
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
        '@referredType':
          type: string
          description: The actual type of the target instance when needed for disambiguation.
      description: A product to be created defined by value or existing defined by
        reference. The polymorphic attributes @type, @schemaLocation & @referredType
        are related to the product entity and not the RelatedProductRefOrValue class
        itself
    ProductRelationship:
      required:
      - product
      - relationshipType
      type: object
      properties:
        relationshipType:
          type: string
          description: Type of the product relationship, such as [bundled] if the
            product is a bundle and you want to describe the bundled products inside
            this bundle; [reliesOn] if the product needs another already owned product
            to rely on (e.g. an option on an already owned mobile access product)
            [targets] or [isTargeted] (depending on the way of expressing the link)
            for any other kind of links that may be useful
        product:
          $ref: '#/components/schemas/ProductRefOrValue'
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
      description: Linked products to the one instantiate, such as [bundled] if the
        product is a bundle and you want to describe the bundled products inside this
        bundle; [reliesOn] if the product needs another already owned product to rely
        on (e.g. an option on an already owned mobile access product) [targets] or
        [isTargeted] (depending on the way of expressing the link) for any other kind
        of links that may be useful
    ProductSpecificationRef:
      required:
      - id
      type: object
      properties:
        id:
          type: string
          description: Unique identifier of a related entity.
        href:
          type: string
          description: Reference of the related entity.
        name:
          type: string
          description: Name of the related entity.
        version:
          type: string
          description: Version of the product specification
        targetProductSchema:
          $ref: '#/components/schemas/TargetProductSchema'
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
        '@referredType':
          type: string
          description: The actual type of the target instance when needed for disambiguation.
      description: 'Product specification reference: A ProductSpecification is a detailed
        description of a tangible or intangible object made available externally in
        the form of a ProductOffering to customers or other parties playing a party
        role.'
    ProductStatusType:
      type: string
      description: Possible values for the status of the product
      enum:
      - created
      - pendingActive
      - cancelled
      - active
      - pendingTerminate
      - terminated
      - suspended
      - 'aborted '
    ProductTerm:
      type: object
      properties:
        description:
          type: string
          description: Description of the productTerm
        name:
          type: string
          description: Name of the productTerm
        duration:
          $ref: '#/components/schemas/Quantity'
        validFor:
          $ref: '#/components/schemas/TimePeriod'
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
      description: Description of a productTerm linked to this product. This represent
        a commitment with a duration
    Quantity:
      type: object
      properties:
        amount:
          type: number
          description: Numeric value in a given unit
          format: float
          default: 1.0
        units:
          type: string
          description: Unit
      description: An amount in a given unit
    QuoteItemRef:
      required:
      - id
      - quoteId
      type: object
      properties:
        id:
          type: string
          description: Id of an item of a quote
        href:
          type: string
          description: Reference of the related entity.
        name:
          type: string
          description: Name of the related entity.
        quoteHref:
          type: string
          description: Reference of the related entity.
        quoteId:
          type: string
          description: Unique identifier of a related entity.
        quoteName:
          type: string
          description: Name of the related entity.
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
        '@referredType':
          type: string
          description: The actual type of the target instance when needed for disambiguation.
      description: It's a Quote item that has been executed previously.
    QuoteRef:
      required:
      - id
      type: object
      properties:
        id:
          type: string
          description: Unique identifier of a related entity.
        href:
          type: string
          description: Reference of the related entity.
        name:
          type: string
          description: Name of the related entity.
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
        '@referredType':
          type: string
          description: The actual type of the target instance when needed for disambiguation.
      description: It's a Quote that has been executed previously
    RelatedChannel:
      required:
      - id
      type: object
      properties:
        id:
          type: string
          description: Unique identifier of a related entity.
        href:
          type: string
          description: Reference of the related entity.
        name:
          type: string
          description: Name of the channel.
        role:
          type: string
          description: Role playing by the channel.
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
        '@referredType':
          type: string
          description: The actual type of the target instance when needed for disambiguation.
      description: Related channel to another entity. May be online web, mobile app,
        social ,etc.
    RelatedParty:
      required:
      - '@referredType'
      - id
      type: object
      properties:
        id:
          type: string
          description: Unique identifier of a related entity.
        href:
          type: string
          description: Reference of the related entity.
        name:
          type: string
          description: Name of the related entity.
        role:
          type: string
          description: Role played by the related party
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
        '@referredType':
          type: string
          description: The actual type of the target instance when needed for disambiguation.
      description: Related Entity reference. A related party defines party or party
        role linked to a specific entity.
    RelatedPlaceRefOrValue:
      required:
      - role
      type: object
      properties:
        id:
          type: string
          description: Unique identifier of the place
        href:
          type: string
          description: Unique reference of the place
        name:
          type: string
          description: A user-friendly name for the place, such as [Paris Store],
            [London Store], [Main Home]
        role:
          type: string
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
        '@referredType':
          type: string
          description: The actual type of the target instance when needed for disambiguation.
      description: Related Entity reference. A related place defines a place described
        by reference or by value linked to a specific entity. The polymorphic attributes
        @type, @schemaLocation & @referredType are related to the place entity and
        not the RelatedPlaceRefOrValue class itself
    RelatedProductOrderItem:
      required:
      - orderItemId
      - productOrderId
      type: object
      properties:
        orderItemAction:
          type: string
          description: Action of the order item for this product
        orderItemId:
          type: string
          description: Identifier of the order item where the product was managed
        productOrderHref:
          type: string
          description: Reference of the related entity.
        productOrderId:
          type: string
          description: Unique identifier of a related entity.
        role:
          type: string
          description: role of the product order item for this product
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
        '@referredType':
          type: string
          description: The actual type of the target instance when needed for disambiguation.
      description: RelatedProductOrderItem (ProductOrder item) .The product order
        item which triggered product creation/change/termination.
    ResourceRef:
      required:
      - id
      type: object
      properties:
        id:
          type: string
          description: Unique identifier of a related entity.
        href:
          type: string
          description: Reference of the related entity.
        name:
          type: string
          description: Name of the resource
        value:
          type: string
          description: 'The resource value that can be used to identify a resource
            with a public key (e.g.: a tel nr, an msisdn)'
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
        '@referredType':
          type: string
          description: The actual type of the target instance when needed for disambiguation.
    ServiceRef:
      required:
      - id
      type: object
      properties:
        id:
          type: string
          description: Unique identifier of a related entity.
        href:
          type: string
          description: Reference of the related entity.
        name:
          type: string
          description: Name of the related entity.
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name
        '@referredType':
          type: string
          description: The actual type of the target instance when needed for disambiguation.
      description: Service reference, for when Service is used by other entities
    TargetProductSchema:
      required:
      - '@schemaLocation'
      - '@type'
      type: object
      properties:
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class
        '@schemaLocation':
          type: string
          description: This field provides a link to the schema describing the target
            product
        '@type':
          type: string
          description: Class type of the target product
      description: The reference object to the schema and type of target product which
        is described by product specification
    TaskStateType:
      type: string
      description: Possible values for the state of a task
      enum:
      - acknowledged
      - terminatedWithError
      - inProgress
      - done
    TimePeriod:
      type: object
      properties:
        endDateTime:
          type: string
          description: End of the time period, using IETC-RFC-3339 format
          format: date-time
        startDateTime:
          type: string
          description: Start of the time period, using IETC-RFC-3339 format. If you
            define a start, you must also define an end
          format: date-time
      description: A period of time, either as a deadline (endDateTime only) a startDateTime
        only, or both
    EventSubscription:
      required:
      - callback
      - id
      type: object
      properties:
        id:
          type: string
          description: Id of the listener
        callback:
          type: string
          description: The callback being registered.
        query:
          type: string
          description: additional data to be passed
      description: Sets the communication endpoint address the service instance must
        use to deliver notification information
    EventSubscriptionInput:
      required:
      - callback
      type: object
      properties:
        callback:
          type: string
          description: The callback being registered.
        query:
          type: string
          description: additional data to be passed
      description: Sets the communication endpoint address the service instance must
        use to deliver notification information
    ProductOrderCreateEvent:
      type: object
      properties:
        id:
          type: string
          description: Identifier of the Process flow
        href:
          type: string
          description: Reference of the ProcessFlow
        eventId:
          type: string
          description: The identifier of the notification.
        eventTime:
          type: string
          description: Time of the event occurrence.
          format: date-time
        eventType:
          type: string
          description: The type of the notification.
        correlationId:
          type: string
          description: The correlation id for this event.
        domain:
          type: string
          description: The domain of the event.
        title:
          type: string
          description: The title of the event.
        description:
          type: string
          description: An explnatory of the event.
        priority:
          type: string
          description: A priority.
        timeOcurred:
          type: string
          description: The time the event occured.
          format: date-time
        event:
          $ref: '#/components/schemas/ProductOrderCreateEventPayload'
      description: The notification data structure
    ProductOrderCreateEventPayload:
      type: object
      properties:
        productOrder:
          $ref: '#/components/schemas/ProductOrder'
      description: The event data structure
    ProductOrderAttributeValueChangeEvent:
      type: object
      properties:
        eventId:
          type: string
          description: The identifier of the notification.
        eventTime:
          type: string
          description: Time of the event occurrence.
          format: date-time
        eventType:
          type: string
          description: The type of the notification.
        correlationId:
          type: string
          description: The correlation id for this event.
        domain:
          type: string
          description: The domain of the event.
        title:
          type: string
          description: The title of the event.
        description:
          type: string
          description: An explnatory of the event.
        priority:
          type: string
          description: A priority.
        timeOcurred:
          type: string
          description: The time the event occured.
          format: date-time
        fieldPath:
          type: string
          description: The path identifying the object field concerned by this notification.
        event:
          $ref: '#/components/schemas/ProductOrderAttributeValueChangeEventPayload'
      description: The notification data structure
    ProductOrderAttributeValueChangeEventPayload:
      type: object
      properties:
        productOrder:
          $ref: '#/components/schemas/ProductOrder'
      description: The event data structure
    ProductOrderDeleteEvent:
      type: object
      properties:
        id:
          type: string
          description: Identifier of the Process flow
        href:
          type: string
          description: Reference of the ProcessFlow
        eventId:
          type: string
          description: The identifier of the notification.
        eventTime:
          type: string
          description: Time of the event occurrence.
          format: date-time
        eventType:
          type: string
          description: The type of the notification.
        correlationId:
          type: string
          description: The correlation id for this event.
        domain:
          type: string
          description: The domain of the event.
        title:
          type: string
          description: The title of the event.
        description:
          type: string
          description: An explnatory of the event.
        priority:
          type: string
          description: A priority.
        timeOcurred:
          type: string
          description: The time the event occured.
          format: date-time
        event:
          $ref: '#/components/schemas/ProductOrderDeleteEventPayload'
      description: The notification data structure
    ProductOrderDeleteEventPayload:
      type: object
      properties:
        productOrder:
          $ref: '#/components/schemas/ProductOrder'
      description: The event data structure
    ProductOrderStateChangeEvent:
      type: object
      properties:
        id:
          type: string
          description: Identifier of the Process flow
        href:
          type: string
          description: Reference of the ProcessFlow
        eventId:
          type: string
          description: The identifier of the notification.
        eventTime:
          type: string
          description: Time of the event occurrence.
          format: date-time
        eventType:
          type: string
          description: The type of the notification.
        correlationId:
          type: string
          description: The correlation id for this event.
        domain:
          type: string
          description: The domain of the event.
        title:
          type: string
          description: The title of the event.
        description:
          type: string
          description: An explnatory of the event.
        priority:
          type: string
          description: A priority.
        timeOcurred:
          type: string
          description: The time the event occured.
          format: date-time
        event:
          $ref: '#/components/schemas/ProductOrderStateChangeEventPayload'
      description: The notification data structure
    ProductOrderStateChangeEventPayload:
      type: object
      properties:
        productOrder:
          $ref: '#/components/schemas/ProductOrder'
      description: The event data structure
    ProductOrderInformationRequiredEvent:
      type: object
      properties:
        eventId:
          type: string
          description: The identifier of the notification.
        eventTime:
          type: string
          description: Time of the event occurrence.
          format: date-time
        eventType:
          type: string
          description: The type of the notification.
        correlationId:
          type: string
          description: The correlation id for this event.
        domain:
          type: string
          description: The domain of the event.
        title:
          type: string
          description: The title of the event.
        description:
          type: string
          description: An explnatory of the event.
        priority:
          type: string
          description: A priority.
        timeOcurred:
          type: string
          description: The time the event occured.
          format: date-time
        fieldPath:
          type: string
          description: The path identifying the object field concerned by this notification.
        event:
          $ref: '#/components/schemas/ProductOrderInformationRequiredEventPayload'
      description: The notification data structure
    ProductOrderInformationRequiredEventPayload:
      type: object
      properties:
        productOrder:
          $ref: '#/components/schemas/ProductOrder'
      description: The event data structure
    CancelProductOrderCreateEvent:
      type: object
      properties:
        id:
          type: string
          description: Identifier of the Process flow
        href:
          type: string
          description: Reference of the ProcessFlow
        eventId:
          type: string
          description: The identifier of the notification.
        eventTime:
          type: string
          description: Time of the event occurrence.
          format: date-time
        eventType:
          type: string
          description: The type of the notification.
        correlationId:
          type: string
          description: The correlation id for this event.
        domain:
          type: string
          description: The domain of the event.
        title:
          type: string
          description: The title of the event.
        description:
          type: string
          description: An explnatory of the event.
        priority:
          type: string
          description: A priority.
        timeOcurred:
          type: string
          description: The time the event occured.
          format: date-time
        event:
          $ref: '#/components/schemas/CancelProductOrderCreateEventPayload'
      description: The notification data structure
    CancelProductOrderCreateEventPayload:
      type: object
      properties:
        cancelProductOrder:
          $ref: '#/components/schemas/CancelProductOrder'
      description: The event data structure
    CancelProductOrderStateChangeEvent:
      type: object
      properties:
        id:
          type: string
          description: Identifier of the Process flow
        href:
          type: string
          description: Reference of the ProcessFlow
        eventId:
          type: string
          description: The identifier of the notification.
        eventTime:
          type: string
          description: Time of the event occurrence.
          format: date-time
        eventType:
          type: string
          description: The type of the notification.
        correlationId:
          type: string
          description: The correlation id for this event.
        domain:
          type: string
          description: The domain of the event.
        title:
          type: string
          description: The title of the event.
        description:
          type: string
          description: An explnatory of the event.
        priority:
          type: string
          description: A priority.
        timeOcurred:
          type: string
          description: The time the event occured.
          format: date-time
        event:
          $ref: '#/components/schemas/CancelProductOrderStateChangeEventPayload'
      description: The notification data structure
    CancelProductOrderStateChangeEventPayload:
      type: object
      properties:
        cancelProductOrder:
          $ref: '#/components/schemas/CancelProductOrder'
      description: The event data structure
    CancelProductOrderInformationRequiredEvent:
      type: object
      properties:
        eventId:
          type: string
          description: The identifier of the notification.
        eventTime:
          type: string
          description: Time of the event occurrence.
          format: date-time
        eventType:
          type: string
          description: The type of the notification.
        correlationId:
          type: string
          description: The correlation id for this event.
        domain:
          type: string
          description: The domain of the event.
        title:
          type: string
          description: The title of the event.
        description:
          type: string
          description: An explnatory of the event.
        priority:
          type: string
          description: A priority.
        timeOcurred:
          type: string
          description: The time the event occured.
          format: date-time
        fieldPath:
          type: string
          description: The path identifying the object field concerned by this notification.
        event:
          $ref: '#/components/schemas/CancelProductOrderInformationRequiredEventPayload'
      description: The notification data structure
    CancelProductOrderInformationRequiredEventPayload:
      type: object
      properties:
        cancelProductOrder:
          $ref: '#/components/schemas/CancelProductOrder'
      description: The event data structure
    Error:
      required:
      - code
      - reason
      type: object
      properties:
        code:
          type: string
          description: Application relevant detail, defined in the API or a common
            list.
        reason:
          type: string
          description: Explanation of the reason for the error which can be shown
            to a client user.
        message:
          type: string
          description: More details and corrective actions related to the error which
            can be shown to a client user.
        status:
          type: string
          description: HTTP Error code extension
        referenceError:
          type: string
          description: URI of documentation describing the error.
          format: uri
        '@baseType':
          type: string
          description: When sub-classing, this defines the super-class.
        '@schemaLocation':
          type: string
          description: A URI to a JSON-Schema file that defines additional attributes
            and relationships
          format: uri
        '@type':
          type: string
          description: When sub-classing, this defines the sub-class entity name.
      description: Used when an API throws an Error, typically with a HTTP error response-code
        (3xx, 4xx, 5xx)
