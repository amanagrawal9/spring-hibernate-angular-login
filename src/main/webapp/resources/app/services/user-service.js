app.service('UserService', function($resource) {
	return $resource('/flikon/:id/:operation', {
		id: '@id',
		operation: '@operation'
	}, {
		current_user: {
			method: 'GET',
			params: {
				operation: 'current_user'
			},
			isArray: false
		},
        register: {
            method: 'POST',
            params: {
                operation: 'register'
            },
            isArray: false
        }
	});
	
});